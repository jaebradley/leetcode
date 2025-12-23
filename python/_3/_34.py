from typing import List

"""
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
"""


class Solution:
    """
    Array is sorted, runtime must be log n. Use binary search to find target. Need to iterate forwards and backwards
    once target value is found.
    """

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left_index, right_index = 0, len(nums) - 1
        while left_index <= right_index:
            middle_index = (left_index + right_index) // 2
            middle_value = nums[middle_index]
            if middle_value == target:
                start_index = middle_index
                while 0 <= (start_index - 1) and nums[start_index - 1] == target:
                    start_index -= 1

                end_index = middle_index
                while (end_index + 1) <= (len(nums) - 1) and nums[end_index + 1] == target:
                    end_index += 1

                return [start_index, end_index]

            if middle_value < target:
                left_index = middle_index + 1
            else:
                right_index = middle_index - 1

        return [-1, -1]


