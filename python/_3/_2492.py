"""
https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
"""
import sys
from collections import deque
from typing import List


class UnionFindSolution:
    class UnionFind:
        def __init__(self, total_node_count):
            self.parents_by_node = dict(map(lambda v: [v, v], range(1, total_node_count + 1)))

        def find_parent(self, node):
            parent = self.parents_by_node[node]
            if node != parent:
                parent = self.find_parent(parent)
                self.parents_by_node[node] = parent
            return parent

        def union(self, first, second):
            first_parent = self.find_parent(first)
            second_parent = self.find_parent(second)
            if first_parent != second_parent:
                self.parents_by_node[first_parent] = second_parent

    """
    Find minimum road distance in the connected component.
    Search every node in connected component.

    Union Find approach:

    Initially, every node is its own parent.
    Each road, pick first node as parent for both nodes if they don't already share a parent.
    Keep track of minimum road distance per parent (initially set to inf).
    Return the minimum road distance for the parent of the target node.
    """

    def minScore(self, n: int, roads: List[List[int]]) -> int:
        union_find = UnionFindSolution.UnionFind(total_node_count=n)
        for (first_node, second_node, distance) in roads:
            union_find.union(first=first_node, second=second_node)

        minimum_score = sys.maxsize
        starting_node_parent = union_find.find_parent(1)
        for (first_node, second_node, distance) in roads:
            if starting_node_parent == union_find.find_parent(first_node) \
                    or starting_node_parent == union_find.find_parent(second_node):
                minimum_score = min(minimum_score, distance)

        return minimum_score


class BfsSolution:
    """
    Build adjacency list of all nodes with road distance.
    Start with node 1.
    Iterate until queue is empty (this means all nodes in the connected component containing 1 have been iterated over).
    Keep track of visited nodes (to avoid cycles).
    For each node that is visited, check to see if the distance to travel to that node is less than the current minimum seen (start with max value integer).
    """

    def minScore(self, n: int, roads: List[List[int]]) -> int:
        adjacency_list = {}
        for (first, second, distance) in roads:
            first_neighbors = adjacency_list.get(first, set([]))
            first_neighbors.add((second, distance))
            adjacency_list[first] = first_neighbors

            second_neighbors = adjacency_list.get(second, set([]))
            second_neighbors.add((first, distance))
            adjacency_list[second] = second_neighbors

        minimum_score = sys.maxsize
        queue = deque([1])
        visited = set([])
        while queue:
            current_node = queue.pop()
            visited.add(current_node)
            for (neighbor, distance) in adjacency_list.get(current_node, set([])):
                if neighbor not in visited:
                    minimum_score = min(minimum_score, distance)
                    queue.append(neighbor)

        return minimum_score
