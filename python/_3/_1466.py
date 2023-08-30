from typing import List


class Solution:
    class Edge:
        def __init__(self, destination: int, outbound: bool):
            self.destination = destination
            self.outbound = outbound

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        adjacency_list = dict(map(lambda node: [node, set()], range(n)))
        for starting_node, destination_node in connections:
            adjacency_list.get(starting_node).add(Solution.Edge(destination=destination_node, outbound=True))
            adjacency_list.get(destination_node).add(Solution.Edge(destination=starting_node, outbound=False))

        return self.helper(0, adjacency_list, set())

    def helper(self, current_node, adjacency_list, visited_nodes) -> int:
        current_node_count = 0
        if current_node is not None and current_node not in visited_nodes:
            visited_nodes.add(current_node)
            for edge in adjacency_list.get(current_node, set()):
                if edge.destination not in visited_nodes:
                    current_node_count += edge.outbound + self.helper(edge.destination, adjacency_list, visited_nodes)
        return current_node_count
