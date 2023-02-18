"""
https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
"""
import sys
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
