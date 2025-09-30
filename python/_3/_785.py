from typing import List, Dict, Optional

"""
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array 
graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is 
an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the 
graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.
"""


class Solution:
    """
    Graph is bipartite if it is "two-colorable".
    Two adjacent vertices can't share the same color.
    DFS through graph (starting with some arbitrary point).
    When DFSing through adjacency list, if any of the connected nodes have the same color as the current node, return
    False, else return True.
    Only continue processing connected nodes that don't have a color calculated.
    Once all nodes have been visited, return True.
    """

    def isBipartite(self, graph: List[List[int]]) -> bool:
        colors_by_node: Dict[int, int] = {}
        for node, _ in enumerate(graph):
            if colors_by_node.get(node) is None and not self.dfs(current_node_color=1, current_node=node, colors_by_node=colors_by_node, graph=graph):
                return False
        return True

    def dfs(self,
            current_node_color: int,
            current_node: int,
            colors_by_node: Dict[int, int],
            graph: List[List[int]]
            ):
        color = colors_by_node.get(current_node)

        if color:
            return current_node_color == color

        colors_by_node[current_node] = current_node_color

        for neighbor in graph[current_node]:
            if not self.dfs(current_node_color=-current_node_color, current_node=neighbor, colors_by_node=colors_by_node, graph=graph):
                return False

        return True
