from collections import deque
from typing import List, Dict, Set

"""
You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge 
between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, 
and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is 
impossible to group the nodes with the given conditions.
"""


class Solution:
    """
    1. Check to see if the graph is bipartite, to see if the graph can be split into groups
    2. For each connected part of the graph, find the largest number of groups that each connected part can be divided
    into

    An important observation here is that the maximum number of groups in a component is determined by the longest
    shortest path between any pair of nodes in that component. This is similar to finding the "height" of the
    component if it were structured like a tree, with different nodes as potential roots. The longest shortest path
    essentially tells us how many layers or groups can be created based on the distances between the nodes.
    """

    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        graph = {}
        for [first_node, second_node] in edges:
            # 0-indexed
            graph.setdefault(first_node - 1, set()).add(second_node - 1)
            graph.setdefault(second_node - 1, set()).add(first_node - 1)

        group_count, colors_by_node = 0, dict(map(lambda v: [v, -1], range(n)))
        for current_node in range(n):
            if colors_by_node.get(current_node, -1) == -1:
                colors_by_node[current_node] = 0
                if not self.is_bipartite(current_node=current_node, colors_by_node=colors_by_node, graph=graph):
                    return -1

        distances_by_node: dict[int, int] = dict(
            map(lambda v: [v, self.get_shortest_longest_path(starting_node=v, graph=graph)], range(n)))
        max_group_count, visited_nodes = 0, set()

        for current_node in range(n):
            if current_node not in visited_nodes:
                max_group_count += self.count_component_groups(current_node=current_node,
                                                               graph=graph,
                                                               visited_nodes=visited_nodes,
                                                               distances_by_node=distances_by_node)

        return max_group_count

    def is_bipartite(self, current_node: int, colors_by_node: Dict[int, int], graph: Dict[int, Set[int]]) -> bool:
        current_node_color = colors_by_node.get(current_node, -1)
        expected_neighbor_node_color = (current_node_color + 1) % 2
        neighbors = graph.get(current_node, {})
        for neighbor in neighbors:
            current_neighbor_color = colors_by_node.get(neighbor, -1)
            if current_neighbor_color == current_node_color:
                return False

            if current_neighbor_color == -1:
                colors_by_node[neighbor] = expected_neighbor_node_color
                if not self.is_bipartite(current_node=neighbor, colors_by_node=colors_by_node, graph=graph):
                    return False

        return True

    def get_shortest_longest_path(self, starting_node: int, graph: Dict[int, Set[int]]) -> int:
        q, visited, distance = deque([starting_node]), {starting_node}, 0
        while q:
            level_node_count = len(q)
            for _ in range(level_node_count):
                current_node = q.pop()

                for neighbor in graph.get(current_node, set()):
                    if neighbor not in visited:
                        visited.add(neighbor)
                        q.appendleft(neighbor)

            distance += 1

        return distance

    def count_component_groups(self, current_node: int, graph: Dict[int, Set[int]], visited_nodes: Set[int],
                               distances_by_node: Dict[int, int]) -> int:
        maximum_groups = distances_by_node.get(current_node, 0)
        visited_nodes.add(current_node)
        for neighbor in graph.get(current_node, set()):
            if neighbor not in visited_nodes:
                maximum_groups = max(maximum_groups, self.count_component_groups(current_node=neighbor, graph=graph,
                                                                                 visited_nodes=visited_nodes,
                                                                                 distances_by_node=distances_by_node))

        return maximum_groups
