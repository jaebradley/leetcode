"""
https://leetcode.com/problems/reachable-nodes-with-restrictions/
"""

from collections import deque
from typing import List


class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        unreachable_nodes = set(restricted)
        adjacency_list = {}
        for (first_node, second_node) in edges:
            first_node_connected_nodes = adjacency_list.get(first_node, set([]))
            if second_node not in unreachable_nodes:
                first_node_connected_nodes.add(second_node)
            adjacency_list[first_node] = first_node_connected_nodes

            second_node_connected_nodes = adjacency_list.get(second_node, set([]))
            if first_node not in unreachable_nodes:
                second_node_connected_nodes.add(first_node)
            adjacency_list[second_node] = second_node_connected_nodes

        visited_nodes = set([])
        queue = deque([0])
        while queue:
            current_node = queue.pop()
            visited_nodes.add(current_node)
            for next_node in adjacency_list.get(current_node, set([])):
                if next_node not in visited_nodes:
                    queue.appendleft(next_node)

        return len(visited_nodes)
