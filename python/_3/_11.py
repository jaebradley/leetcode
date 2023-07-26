"""
https://leetcode.com/problems/container-with-most-water/
"""

from typing import List


class Solution:
    """
    area = min(starting height, ending height) * (ending height index - starting height index)

    Start at first and last indices.
    Calculate area.
    For smaller of two indices, move towards the other index, and stop when height >= taller of two indices is found.
    This is because the only way the area could be larger is if an index with a taller height is identified.
    Do this until the indices cross.
    """

    def maxArea(self, height: List[int]) -> int:
        left_index, right_index = 0, len(height) - 1
        max_area = float("-inf")
        while left_index < right_index:
            max_area = max(max_area, min(height[left_index], height[right_index]) * (right_index - left_index))
            if height[left_index] < height[right_index]:
                left_index += 1
            else:
                right_index -= 1
        return max_area
