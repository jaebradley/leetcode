from typing import List

"""
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the 
absolute difference between any two elements of this subarray is less than or equal to limit.
"""


class Solution:
    """
    Two dequeue solution + sliding window
    Problem boils down to what is max element in subarray and what is minimum element in subarray
    """
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        raise NotImplementedError
