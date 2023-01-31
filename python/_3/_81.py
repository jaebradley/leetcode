"""
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
"""

from typing import List


class Solution:
    """
    Think of the array as two non-decreasing arrays that are "split" on the pivot point.

    Given the start of one of the arrays, all values to the right of it are >= the starting value.

    If a value is distributed across both arrays like [10, 10, 10, 10, 10, 5, 8, 8, 9, 10]
    then a "midpoint value" might be equal to the starting index value, but the "relative" target value might be to the
    "left" or "right" of the value at the array value.
    """

    def search(self, nums: List[int], target: int) -> bool:
        starting_index = 0
        ending_index = len(nums) - 1
        if ending_index >= 0:
            while starting_index <= ending_index:
                midpoint_index = round(starting_index + ((ending_index - starting_index) / 2))
                midpoint_value = nums[midpoint_index]
                if midpoint_value == target:
                    return True

                if midpoint_value == nums[starting_index]:
                    starting_index += 1
                    continue

                midpoint_right = midpoint_value >= nums[starting_index]
                value_right = target >= nums[starting_index]

                if midpoint_right ^ value_right:
                    if midpoint_right:
                        starting_index = midpoint_index + 1
                    else:
                        ending_index = midpoint_index - 1
                else:
                    if target > midpoint_value:
                        starting_index = midpoint_index + 1
                    else:
                        ending_index = midpoint_index - 1

        return False
