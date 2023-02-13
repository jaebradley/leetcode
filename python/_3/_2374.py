"""
https://leetcode.com/problems/node-with-highest-edge-score/
"""

from typing import List


class Solution:
    """
    Use a Map to keep track of destination node score (basically the counts of the values from the input array).
    Iterate over the Map, keeping track of the highest score seen and the node value associated with the highest score value.
    Return the node value.
    """

    def edgeScore(self, edges: List[int]) -> int:
        scores_by_edge = {}
        max_score_seen = 0
        minimum_node_value_for_max_score = len(edges)
        for index, destination_edge in enumerate(edges):
            destination_edge_score = scores_by_edge.get(destination_edge, 0)
            next_destination_edge_score = destination_edge_score + index
            scores_by_edge[destination_edge] = next_destination_edge_score
            if next_destination_edge_score == max_score_seen:
                minimum_node_value_for_max_score = min(destination_edge, minimum_node_value_for_max_score)
            elif next_destination_edge_score > max_score_seen:
                max_score_seen = next_destination_edge_score
                minimum_node_value_for_max_score = destination_edge

        return minimum_node_value_for_max_score
