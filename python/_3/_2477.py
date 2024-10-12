"""
https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
"""
import math
from collections import deque
from typing import List


class DfsSolution:
    fuel = 0

    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        adjacency_list = {}
        for road in roads:
            (first_city, second_city) = road
            cities_connected_to_first_city = adjacency_list.get(first_city, set([]))
            cities_connected_to_first_city.add(second_city)
            adjacency_list[first_city] = cities_connected_to_first_city

            cities_connected_to_second_city = adjacency_list.get(second_city, set([]))
            cities_connected_to_second_city.add(first_city)
            adjacency_list[second_city] = cities_connected_to_second_city

        self.dfs(0, -1, seats, adjacency_list)

        return self.fuel

    def dfs(self, current_node, parent, seats, adjacency_list):
        representatives = 1
        for next_node in adjacency_list.get(current_node, set([])):
            if next_node != parent:
                representatives += self.dfs(next_node, current_node, seats, adjacency_list)

        if 0 != current_node:
            self.fuel += math.ceil(representatives / seats)

        return representatives


class BfsSolution:
    """
    Idea is to start from leaves and move "up" the tree.
    Since this is a tree, each node has exactly one parent (except the root node).
    Build an adjacency list for a node's parent + children.
    Add the leaves (degree = 1) to a queue.
    Pop cities of the queue (each city in the queue should be a leaf in the currently unexplored tree).
    For each city, look up the number of representatives, and calculate the fuel cost (# of representatives / seats) -
    this fuel cost represents the cost of transporting the representatives from the city to its parent city.
    For each neighboring city, decrement the degrees for that city (since have explored at least one neighbor).
    For each neighboring city, add the number of representatives to that city's representative count.
    If the neighbor has a degree count of 1 and is not the root node, then add it to the queue (it's a valid "leaf" of the currently discovered tree).
    Once we reach the root node, we've already calculated the fuel to get to the root, so no other calculations are needed.
    Runtime is O(number of nodes).
    Memory is O(number of nodes)
    """

    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        adjacency_list = {}
        degrees = {}
        for road in roads:
            (first_city, second_city) = road
            cities_connected_to_first_city = adjacency_list.get(first_city, set([]))
            cities_connected_to_first_city.add(second_city)
            adjacency_list[first_city] = cities_connected_to_first_city
            degrees[first_city] = 1 + degrees.get(first_city, 0)

            cities_connected_to_second_city = adjacency_list.get(second_city, set([]))
            cities_connected_to_second_city.add(first_city)
            adjacency_list[second_city] = cities_connected_to_second_city
            degrees[second_city] = 1 + degrees.get(second_city, 0)

        representatives = {}
        queue = deque([])
        for city, connected_nodes in adjacency_list.items():
            if 1 == len(connected_nodes) and 0 != city:
                queue.append(city)
            representatives[city] = 1

        fuel = 0
        while queue:
            current_city = queue.popleft()
            current_representatives = representatives[current_city]
            fuel += math.ceil(current_representatives / seats)
            for neighbor in adjacency_list.get(current_city, set([])):
                degrees[neighbor] -= 1
                representatives[neighbor] += current_representatives

                if 1 == degrees[neighbor] and 0 != neighbor:
                    queue.append(neighbor)

        return fuel
