"""
https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
"""
import math
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
