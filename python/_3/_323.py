from typing import List

"""
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
"""


class Solution:
    class DisjointedSetUnion:
        def __init__(self, nodes):
            self.parents_by_node = dict(map(lambda v: (v, v), range(nodes)))
            self.sizes_by_node = dict(map(lambda v: (v, 1), range(nodes)))
            self.connected_components_count = nodes

        def find_parent(self, node):
            current_parent = self.parents_by_node[node]

            if current_parent != node:
                self.parents_by_node[node] = self.find_parent(current_parent)
            return self.parents_by_node[node]

        def union(self, first_node, second_node):
            first_node_parent = self.find_parent(first_node)
            second_node_parent = self.find_parent(second_node)
            if first_node_parent != second_node_parent:
                self.connected_components_count -= 1
                first_node_parent_size, second_node_parent_size = self.sizes_by_node[first_node_parent], \
                    self.sizes_by_node[second_node_parent]
                if first_node_parent_size >= second_node_parent_size:
                    self.parents_by_node[second_node_parent] = first_node_parent
                    self.sizes_by_node[first_node_parent] += self.sizes_by_node[second_node_parent]
                else:
                    self.parents_by_node[first_node_parent] = second_node_parent
                    self.sizes_by_node[second_node_parent] += self.sizes_by_node[first_node_parent]

    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        dsu = Solution.DisjointedSetUnion(n)
        for first_vertex, second_vertex in edges:
            dsu.union(first_vertex, second_vertex)

        return dsu.connected_components_count
