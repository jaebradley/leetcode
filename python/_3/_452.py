"""
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
"""

from typing import List

class Solution:
    """
    Find all the intervals ("points") that all overlap.

    Order points by starting index value, then ending index value
    Iterate over points, grouping points where the current point does not start after the smallest end value seen.
    If the current point starts after the smallest end value seen, then increment the arrow count and keep track of a new group.
    """
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        arrow_count = 0
        ordered_points = sorted(points, key=lambda point: point[0])
        smallest_end_value = -float("infinity")

        for (start_value, end_value) in ordered_points:
            smallest_end_value = min(smallest_end_value, end_value)
            if start_value > smallest_end_value:
                arrow_count += 1
                smallest_end_value = end_value

        return arrow_count
