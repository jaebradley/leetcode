"""
https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
"""

from collections import deque
from typing import List, Dict


class Solution:
    """
    Directed edges
    Find node where max(distance from node 1 to end node, distance from node 2 to end node) is minimized

    BFS from both nodes
    Keep track of searched nodes for each BFS
    Find first node(s) that are in both sets of searched nodes
    Select smallest index node from matching nodes
    """

    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        all_nodes = set([])
        adjacency_list = dict()
        for starting_node, ending_node in enumerate(edges):
            if ending_node >= 0:
                destination_nodes = adjacency_list.get(starting_node, set([]))
                destination_nodes.add(ending_node)
                adjacency_list[starting_node] = destination_nodes
                all_nodes.add(starting_node)
                all_nodes.add(ending_node)

        first_node_distances = self.bfs(node1, adjacency_list)
        second_node_distances = self.bfs(node2, adjacency_list)
        current_minimum_node = [float("inf"), float("inf")]

        for node in all_nodes:
            if node in first_node_distances and node in second_node_distances:
                maximum_distance_between_nodes = max(first_node_distances.get(node), second_node_distances.get(node))
                if maximum_distance_between_nodes < current_minimum_node[0]:
                    current_minimum_node = [maximum_distance_between_nodes, node]

                elif maximum_distance_between_nodes == current_minimum_node[0]:
                    current_minimum_node[1] = min(current_minimum_node[1], node)

        if current_minimum_node[0] == float("inf"):
            return -1

        return int(current_minimum_node[1])

    def bfs(self, starting_node, adjacency_list) -> Dict[int, int]:
        distances_by_node = dict()
        q = deque([starting_node])

        current_distance = 0
        while q:
            level_length = len(q)
            for _ in range(level_length):
                current_node = q.pop()
                distances_by_node[current_node] = current_distance

                for next_node in adjacency_list.get(current_node, set([])):
                    if next_node not in distances_by_node:
                        q.appendleft(next_node)

            current_distance += 1

        return distances_by_node
