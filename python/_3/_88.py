"""
https://leetcode.com/problems/merge-sorted-array/description/
"""

from typing import List


class Solution:
    """
    "Fill" in the zeroes starting from the back of both arrays.
    If the greatest element in num1 >= greatest element in num2, add the num1 value to the back of the array (replacing a zero)
    At some point, the element will be overwritten by either a value in num2 or num1.
    If there are any num2 values left, put them in the front of num1.
    """
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        first_index = m
        second_index = n

        while second_index > 0 and first_index > 0:
            current_first = nums1[first_index - 1]
            current_second = nums2[second_index - 1]
            insertion_index = first_index + second_index - 1

            if current_first > current_second:
                insertion_value = current_first
                first_index -= 1
            else:
                insertion_value = current_second
                second_index -= 1

            nums1[insertion_index] = insertion_value

        if second_index > 0:
            nums1[:second_index] = nums2[:second_index]