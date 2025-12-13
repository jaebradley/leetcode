"""
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
"""
import math
from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        negative_index, positive_index, result = 0, len(nums) - 1, [0] * len(nums)
        while negative_index <= positive_index:
            left_value, right_value = abs(nums[negative_index]), nums[positive_index]
            left_value_greater_than_right_value = left_value > right_value
            result[positive_index - negative_index] = int(
                math.pow(left_value if left_value_greater_than_right_value else right_value, 2))

            negative_index += int(left_value_greater_than_right_value)
            positive_index -= int(not left_value_greater_than_right_value)

        return result
