"""
https://leetcode.com/problems/find-k-closest-elements/
"""
import heapq
from typing import List


class Solution:
    """
    Approach:

    Compare abs(value - x) and then first value < second value when picking which values to keep.
    """

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        priority_queue = []
        for value in arr:
            closeness = abs(value - x)
            heapq.heappush(priority_queue, (closeness, value))

        closest_elements = heapq.nsmallest(k, priority_queue)
        return sorted(list(map(lambda value_context: value_context[1], closest_elements)))
