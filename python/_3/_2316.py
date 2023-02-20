"""
https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
"""
import itertools
import math
from typing import List


class Solution:
    class UnionFind:
        def __init__(self, node_count):
            self.parent_by_node = dict(map(lambda value: [value, value], range(0, node_count)))
            self.rank_by_node = dict(map(lambda value: [value, 0], range(0, node_count)))

        def find_parent(self, node):
            parent = self.parent_by_node.get(node)
            if node != parent:
                parent = self.find_parent(parent)
                self.parent_by_node[node] = parent
            return parent

        def union(self, first_node, second_node):
            first_node_parent = self.find_parent(first_node)
            second_node_parent = self.find_parent(second_node)

            if first_node_parent != second_node_parent:
                first_node_parent_rank = self.rank_by_node.get(first_node_parent)
                second_node_parent_rank = self.rank_by_node.get(second_node_parent)
                if first_node_parent_rank < second_node_parent_rank:
                    self.parent_by_node[first_node_parent] = second_node_parent
                elif second_node_parent_rank > first_node_parent_rank:
                    self.parent_by_node[second_node_parent] = first_node_parent
                else:
                    self.parent_by_node[first_node_parent] = second_node_parent
                    self.rank_by_node[second_node_parent] += 1

    """
    Approach:

    Nodes that can be reached from each other are in the same connected component.
    Conversely, nodes that cannot be reached from each other are in different connected components.
    Pairs of nodes are # nodes in connected component 1 x # nodes in connected component 2, etc.
    Union Find the graph, compute the number of nodes in each connected component / distinct parent.
    """

    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        union_find = Solution.UnionFind(node_count=n)
        for (first_node, second_node) in edges:
            union_find.union(first_node, second_node)

        counts_by_parent = {}
        for node in range(0, n):
            parent = union_find.find_parent(node)
            counts = counts_by_parent.get(parent, 0)
            counts_by_parent[parent] = counts + 1

        if 1 == len(counts_by_parent.keys()):
            return 0

        return sum(map(lambda pair: math.prod(pair), itertools.combinations(counts_by_parent.values(), 2)))
