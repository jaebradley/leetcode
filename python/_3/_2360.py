"""
https://leetcode.com/problems/longest-cycle-in-a-graph/
"""

from typing import List, Set


class Solution:
    max_length = -1
    """
    DFS

    Keep track of path along DFS.
    If cycle exists, keep a mapping of starting node to path / length
    Keep track of all visited nodes.
    Iterate over all nodes, DFSing through all nodes that have not been visited.
    """

    def longestCycle(self, edges: List[int]) -> int:
        Solution.max_length = -1
        visited_nodes = set([])
        for starting_node, ending_node in enumerate(edges):
            if ending_node not in visited_nodes:
                self.dfs(ending_node, edges, visited_nodes, [starting_node])

        return Solution.max_length

    def dfs(self, current_node: int, edges: List[int], visited_nodes: Set[int], path: List[int]):
        if -1 != current_node:
            if current_node in visited_nodes:
                try:
                    Solution.max_length = max(
                        Solution.max_length,
                        len(path) - path.index(current_node))
                except ValueError:
                    # Expected in some cases
                    return
            else:
                visited_nodes.add(current_node)
                path.append(current_node)

                return self.dfs(edges[current_node], edges, visited_nodes, path)
