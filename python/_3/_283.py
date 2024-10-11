"""
https://leetcode.com/problems/move-zeroes/description/
"""

from typing import List


class Solution:
    """
    Two pointers:
    First pointer is the left most 0 index
    Second pointer is the first non-0 index after the first pointer
    If first pointer value is 0 and second pointer value is non-zero, swap the values at the indices
    Then increment the second pointer until it reaches the next non-zero value or reaches the end of the list
    Then increment the first pointer until it reaches the next 0 value or passes the second pointer
    """

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        non_zero_index = 1
        zero_index = 0

        while len(nums) > non_zero_index and len(nums) > zero_index:
            non_zero_index_value = nums[non_zero_index]
            zero_index_value = nums[zero_index]
            if non_zero_index_value != 0 and zero_index_value == 0 and non_zero_index > zero_index:
                nums[non_zero_index] = zero_index_value
                nums[zero_index] = non_zero_index_value
                non_zero_index += 1
                zero_index += 1

            if non_zero_index_value == 0:
                non_zero_index += 1

            if zero_index_value != 0:
                zero_index += 1

            non_zero_index = max(non_zero_index, zero_index + 1)
