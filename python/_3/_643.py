"""
https://leetcode.com/problems/maximum-average-subarray-i/description/
"""

from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        starting_index, ending_index = 0, k - 1
        current_sum = current_maximum_sum = sum(nums[starting_index:ending_index + 1])
        while ending_index < len(nums) - 1:
            diff = nums[ending_index + 1] - nums[starting_index]
            current_sum += diff
            current_maximum_sum = max(current_maximum_sum, current_sum)
            starting_index += 1
            ending_index += 1
        return current_maximum_sum / k
