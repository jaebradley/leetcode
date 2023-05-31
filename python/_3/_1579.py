"""
https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
"""

from typing import List


class Solution:
    class UnionFind:
        def __init__(self, nodes: int):
            self.parents_by_node = dict(map(lambda node: [node, node], range(1, 1 + nodes)))
            self.distinct_components = nodes

        def find_parent(self, node: int) -> int:
            current_parent = self.parents_by_node.get(node)
            if current_parent != node:
                current_parent = self.find_parent(current_parent)
                self.parents_by_node[node] = current_parent

            return current_parent

        def union(self, first_node: int, second_node: int) -> bool:
            first_node_parent, second_node_parent = self.find_parent(first_node), self.find_parent(second_node)
            if first_node_parent == second_node_parent:
                return False

            self.parents_by_node[first_node_parent] = second_node_parent
            self.distinct_components -= 1
            return True

        def is_fully_traversable(self) -> bool:
            return 1 == self.distinct_components

    """
    Union Find Solution:

    The fewest number of edges possible occurs when only adding the necessary edges to the connected components for
    Alice and Bob.

    The connected components for Alice and Bob can be identified using Union Find.

    Prioritize the type 3 edges as they are more "efficient" and for each edge that adds another node to the connected
    components for Alice and Bob, increment an edge count.

    If Alice or Bob's connected components do not include all of the n nodes in the graph,
    then return -1.
    """

    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        edges.sort(key=lambda k: k[0], reverse=True)
        bob = Solution.UnionFind(n)
        alice = Solution.UnionFind(n)
        edges_added_to_graph = 0

        for edge_type, first_node, second_node in edges:
            if 3 == edge_type:
                bob_union_result = bob.union(first_node, second_node)
                alice_union_result = alice.union(first_node, second_node)

                if bob_union_result or alice_union_result:
                    edges_added_to_graph += 1

            elif 2 == edge_type:
                if bob.union(first_node, second_node):
                    edges_added_to_graph += 1

            elif 1 == edge_type:
                if alice.union(first_node, second_node):
                    edges_added_to_graph += 1

        if bob.is_fully_traversable() and alice.is_fully_traversable():
            # The number of maximum edges that can be removed is the number of total edges - the edges added to the
            # graph (which is the "minimum" number of edges that can make the graph traversable)
            return len(edges) - edges_added_to_graph

        return -1
