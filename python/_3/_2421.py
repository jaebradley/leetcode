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

    good path(start, end) = (good path(start - 1, end) and val(start - 1) == val(start))
        or good path(start, end - 1) and val(end - 1) == val(end))
        or (good path(start - 1, end - 1) and val(start) == val(end) and val(start) >= val(start - 1)

    good path for same node start and end is true, else all other combinations are false
    
    """
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
