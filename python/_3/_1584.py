"""
https://leetcode.com/problems/min-cost-to-connect-all-points/
"""
import heapq
from typing import List


class Solution:
    """
    Prim's algorithm:

    Start with an arbitrary node.
    Add it to MST.
    For each node not in the MST, calculate the distance from each node in the MST.
    Add the node with the smallest distance, and add the distance to the total distance.
    Once all nodes have been added, return the total distance.
    """

    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        minimum_spanning_tree = set([])
        total_cost = 0

        weighted_vertices = [(0, 0)]
        while len(minimum_spanning_tree) < len(points):
            weight, vertex = heapq.heappop(weighted_vertices)
            if vertex not in minimum_spanning_tree:
                total_cost += weight
                minimum_spanning_tree.add(vertex)
                for next_vertex in range(len(points)):
                    if next_vertex not in minimum_spanning_tree and next_vertex != vertex:
                        heapq.heappush(
                            weighted_vertices,
                            (abs(points[next_vertex][0] - points[vertex][0]) +
                             abs(points[next_vertex][1] - points[vertex][1]), next_vertex))
        return total_cost
