"""
https://leetcode.com/problems/range-sum-query-immutable/
"""
from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.left_to_right_sums = [0] * (1 + len(nums))
        self.right_to_left_sums = [0] * (1 + len(nums))
        self.total_sum = 0

        current_sum = 0
        for i in range(len(nums)):
            self.left_to_right_sums[i + 1] = self.left_to_right_sums[i] + nums[i]
            self.right_to_left_sums[len(nums) - i - 1] = self.right_to_left_sums[len(nums) - i] + nums[
                len(nums) - i - 1]
            current_sum += nums[i]
        self.total_sum = current_sum

    def sumRange(self, left: int, right: int) -> int:
        left_to_right_sum = self.left_to_right_sums[left]
        right_to_left_sum = self.right_to_left_sums[right + 1]
        return self.total_sum - right_to_left_sum - left_to_right_sum