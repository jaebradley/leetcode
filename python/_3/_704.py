from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            midpoint = (left + right) // 2
            midpoint_value = nums[midpoint]
            if target == midpoint_value:
                return midpoint

            if target < midpoint_value:
                right = midpoint - 1
            else:
                left = midpoint + 1

        return -1
