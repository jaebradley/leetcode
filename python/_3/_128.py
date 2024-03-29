"""
https://leetcode.com/problems/longest-consecutive-sequence/description/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
"""

from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest_streak = 0
        numbers = set(nums)
        for num in nums:
            if (num - 1) not in numbers:
                current_number = num + 1
                current_streak = 1

                while current_number in numbers:
                    current_number += 1
                    current_streak += 1

                longest_streak = max(longest_streak, current_streak)

        return longest_streak
