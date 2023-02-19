"""
https://leetcode.com/problems/maximum-star-sum-of-a-graph/
"""
import heapq
from typing import List


class Solution:
    """
    Star graph: "it is a subset of edges of the given graph such that there exists a common node for all edges."
    Not all edges for a given node need to be considered.

    Max sum of all the combinations of nodes in an adjacency list.
    Sum if include all positive value nodes, sorting for the first k in each set of nodes?
    Collect all nodes into an adjacency list (Map<Node, Set<Node>).
    Sort each node values, for the top k values (if they have greater than k associated nodes)
    Sum these k values, return the max seen.
    """

    def maxStarSum(self, vals: List[int], edges: List[List[int]], k: int) -> int:
        max_sum_by_node = max(vals)
        if 0 < k or 0 < len(edges):
            adjacency_list = {}
            for (first_node, second_node) in edges:
                connected_to_first_node = adjacency_list.get(first_node, set([]))
                connected_to_first_node.add(second_node)
                adjacency_list[first_node] = connected_to_first_node

                connected_to_second_node = adjacency_list.get(second_node, set([]))
                connected_to_second_node.add(first_node)
                adjacency_list[second_node] = connected_to_second_node

            for node, connected_nodes in adjacency_list.items():
                values_to_consider = heapq.nlargest(
                    k,
                    list(filter(lambda value: value >= 0, map(lambda node_index: vals[node_index], connected_nodes))))
                max_sum_by_node = max(max_sum_by_node, sum(values_to_consider) + vals[node])

        return max_sum_by_node
