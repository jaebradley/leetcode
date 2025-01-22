import math
from typing import List

"""
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.
"""


class Solution:
    """
    Binary search.
    The single element we're trying to find will be in the odd set of values left or right of the current value.
    When calculating whether the left or right subarray is odd, need to take into account whether the value left or right
    of the current value is the same.
    """

    def singleNonDuplicate(self, nums: List[int]) -> int:
        minimum_index, maximum_index = 0, len(nums) - 1
        while minimum_index < maximum_index:
            target_index = minimum_index + ((maximum_index - minimum_index) // 2)
            target_value = nums[target_index]
            right_half_is_even = (maximum_index - target_index) % 2 == 0

            if target_value == nums[target_index - 1]:
                if right_half_is_even:
                    maximum_index = target_index - 2
                else:
                    minimum_index = target_index + 1
            elif target_value == nums[target_index + 1]:
                if right_half_is_even:
                    minimum_index = target_index + 2
                else:
                    maximum_index = target_index - 1
            else:
                return nums[target_index]

        return nums[minimum_index]
