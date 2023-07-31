from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        total_sum, left_sum = sum(nums), 0

        for index, value in enumerate(nums):
            if left_sum == (total_sum - left_sum - value):
                return index
            left_sum += value

        return -1
