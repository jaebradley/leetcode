"""
https://leetcode.com/problems/number-of-good-paths/
"""
import math
from typing import List


class Solution:
    class UnionFind:
        def __init__(self, node_count: int):
            self.parents_by_node = dict(map(lambda node: [node, node], range(node_count)))

        def find(self, node):
            parent = self.parents_by_node[node]
            if parent == node:
                return parent

            parent = self.find(parent)
            self.parents_by_node[node] = parent
            return parent

        def union(self, first_node, second_node):
            first_node_parent, second_node_parent = self.find(node=first_node), self.find(node=second_node)
            if first_node_parent != second_node_parent:
                self.parents_by_node[first_node_parent] = second_node_parent

    """
    A good path is a simple path that satisfies the following conditions:

    The starting node and the ending node have the same value.
    All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).

    Return the number of distinct good paths.

    Build adjacency list, but only add neighbors that are <= current node value.
    Build mapping of value to node indices that have the same value.
    For smallest value, union find all the connected nodes.
    Increment the good path count by 1 for each node.
    Increment the good path count by count of nodes that are connected like (count * ((count - 1) / 2)).
    Move to the next largest value.
    """

    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        node_indices_by_value = {}
        for index, value in enumerate(vals):
            node_indices = node_indices_by_value.get(value, set([]))
            node_indices.add(index)
            node_indices_by_value[value] = node_indices

        adjacency_list = {}
        for (first_node, second_node) in edges:
            if vals[first_node] > vals[second_node]:
                first_node_smaller_neighbors = adjacency_list.get(first_node, set([]))
                first_node_smaller_neighbors.add(second_node)
                adjacency_list[first_node] = first_node_smaller_neighbors
            else:
                second_node_smaller_neighbors = adjacency_list.get(second_node, set([]))
                second_node_smaller_neighbors.add(first_node)
                adjacency_list[second_node] = second_node_smaller_neighbors

        union_find = Solution.UnionFind(node_count=len(vals))

        good_path_count = 0
        for value in sorted(node_indices_by_value.keys()):
            node_indices = node_indices_by_value[value]
            for node_index in node_indices:
                for neighboring_node in adjacency_list.get(node_index, set([])):
                    union_find.union(node_index, neighboring_node)

            good_path_count += len(node_indices)

            same_value_node_count_sharing_parent = {}
            for node_index in node_indices:
                parent = union_find.find(node_index)
                node_count = same_value_node_count_sharing_parent.get(parent, 0) + 1
                same_value_node_count_sharing_parent[parent] = node_count

            for _, count in same_value_node_count_sharing_parent.items():
                good_path_count += int(count * ((count - 1) / 2))

        return good_path_count
