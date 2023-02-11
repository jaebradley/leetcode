"""
https://leetcode.com/problems/max-consecutive-ones-iii/
"""

from typing import List


class Solution:

    def longestOnes(self, nums: List[int], k: int) -> int:
        start_index = 0
        ones_count = 0

        for end_index in range(0, len(nums)):
            current_number = nums[end_index]
            if 1 == current_number:
                ones_count += 1

            if end_index - start_index - ones_count + 1 > k:
                starting_number = nums[start_index]
                if 1 == starting_number:
                    ones_count -= 1
                start_index += 1

        return end_index - start_index + 1
