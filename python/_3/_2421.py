"""
https://leetcode.com/problems/number-of-good-paths/
"""

from typing import List


class Solution:
    """
    A good path is a simple path that satisfies the following conditions:

    The starting node and the ending node have the same value.
    All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).

    Return the number of distinct good paths.

    Observations:
    * If a path is a good path for X, then it will also be a good path for X + 1
    * If values along the path are added to a max heap, the starting value should be the top value in the max heap
    * If a path is a good path for X, it will also be a good path for all starting / end values within the same path that have the same value
    * Values on a path are in the same connected component
    * Keep track of distinct values (and their frequency) for each connected component
    """
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
