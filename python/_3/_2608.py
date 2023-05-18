"""
https://leetcode.com/problems/shortest-cycle-in-a-graph/
"""

from typing import List, Dict, Set


class BfsSolution:
    """
    Create adjacency list from the n value and the edges
    Map<Starting Node, Set<Adjacent Node>>

    Keep a visited edges set.

    For each starting node, add the node to a queue.
    For each adjacent node, mark both directed edges as traversed.
    Keep track of level count
    """

    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        shortest_cycle_length = float("inf")

        adjacency_list = dict(map(lambda v: [v, set([])], range(n)))
        for first_node, second_node in edges:
            adjacency_list.get(first_node).add(second_node)
            adjacency_list.get(second_node).add(first_node)

        for starting_node in range(n):
            shortest_cycle_length = min(shortest_cycle_length,
                                        self.bfs(adjacency_list, n, starting_node))

        return -1 if float("inf") == shortest_cycle_length else shortest_cycle_length

    def bfs(self, adjacency_list, n, starting_node):
        local_minimum = float("inf")
        distance_from_starting_node = [float("inf")] * n
        distance_from_starting_node[starting_node] = 0
        nodes = [starting_node]
        for current_node in nodes:
            for next_node in adjacency_list.get(current_node):
                # Haven't visited the next node before
                if float("inf") == distance_from_starting_node[next_node]:
                    distance_from_starting_node[next_node] = 1 + distance_from_starting_node[current_node]
                    nodes.append(next_node)
                # If the next node has been visited (since it has a distance value)
                # and the current node has been visited (since it also has a distance value)
                # and the next node's distance value is greater than or equal to the current node's distance value
                # (which means the next node was NOT visited before the current node was first visited)
                # This means a cycle exists.
                # Iterate over all nodes to capture all possible cycles, keeping track of the smallest one seen.
                elif distance_from_starting_node[current_node] <= distance_from_starting_node[next_node]:
                    local_minimum = min(
                        local_minimum,
                        1 + distance_from_starting_node[current_node] + distance_from_starting_node[next_node]
                    )

        return local_minimum


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
