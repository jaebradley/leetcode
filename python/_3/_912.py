from typing import List

"""
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest 
space complexity possible.
"""


class Solution:
    """
    Sort left and right parts of list.
    Merge the sorted parts.
    Merging the two parts involves iterating over the elements in both parts and choosing the smallest elements from
    either list.
    """
    def sortArray(self, nums: List[int]) -> List[int]:
        if 1 >= len(nums):
            return nums
        midpoint_index = len(nums) // 2
        left_values = self.sortArray(nums[:midpoint_index])
        right_values = self.sortArray(nums[midpoint_index:])
        return Solution.merge(left_values=left_values, right_values=right_values)

    @staticmethod
    def merge(left_values: list[int], right_values: list[int]) -> list[int]:
        values, left_index, right_index = [], 0, 0
        while left_index < len(left_values) and right_index < len(right_values):
            left_value, right_value = left_values[left_index], right_values[right_index]
            if left_value > right_value:
                values.append(right_value)
                right_index += 1
            else:
                values.append(left_value)
                left_index += 1

        return values + left_values[left_index:] + right_values[right_index:]
