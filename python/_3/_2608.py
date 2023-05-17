"""
https://leetcode.com/problems/shortest-cycle-in-a-graph/
"""

from typing import List, Dict, Set


class DfsSolution:
    shortest_cycle_length = float("inf")
    """
    DFS

    Create adjacency list from the n value and the edges
    Map<Starting Node, Set<Adjacent Node>>

    Keep a visited nodes set.

    Keep track of a path when traversing starting from some starting node.
    If the traversal hits a previously visited node, check to see if the node is in the current path.
    If the node is in the current path, see if the distance between the index of the node vs. the length of the path is less than the current minimum cycle length.
    If the node is not in the current path, it has already been traversed and remaining traversal can be ignored.
    """

    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        DfsSolution.shortest_cycle_length = float("inf")

        adjacency_list = dict(map(lambda v: [v, set([])], range(n)))
        for first_node, second_node in edges:
            adjacency_list.get(first_node).add(second_node)
            adjacency_list.get(second_node).add(first_node)

        for starting_node in range(n):
            self.dfs(starting_node, adjacency_list, list(map(lambda v: 0, range(n))), [])

        return -1 if float("inf") == DfsSolution.shortest_cycle_length else DfsSolution.shortest_cycle_length

    def dfs(self,
            current_node: int,
            adjacency_list: Dict[int, Set[int]],
            last_node_visit_distance: List[int],
            current_path: List[int]):
        if last_node_visit_distance[current_node] > 0:
            distance_between_last_seen_node_and_current_node = len(current_path) - last_node_visit_distance[
                current_node]
            if distance_between_last_seen_node_and_current_node > 2:
                try:
                    DfsSolution.shortest_cycle_length = min(
                        DfsSolution.shortest_cycle_length,
                        distance_between_last_seen_node_and_current_node
                    )
                except ValueError:
                    pass
        else:
            previous_visit_distance = last_node_visit_distance[current_node]
            last_node_visit_distance[current_node] = len(current_path)
            current_path.append(current_node)

            for adjacent_node in adjacency_list.get(current_node):
                self.dfs(adjacent_node, adjacency_list, last_node_visit_distance, current_path)

            current_path.pop()
            last_node_visit_distance[current_node] = previous_visit_distance
