"""
https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
"""

from typing import List


class Solution:
    """
    Set first and second values to max value.
    Iterate over the input numbers.
    If a number is less than the current first value in the triplet, then set the first value to it (and skip over setting the second value)
    If the number is greater than the first value, but less than the second value, set the second value to it
    If the number is greater than the first and second values, we've completed the triplet, and a triplet exists.
    If all the numbers have been exhausted, then no triplet exists.
    """

    def increasingTriplet(self, nums: List[int]) -> bool:
        first = second = float('inf')
        for n in nums:
            if n <= first:
                first = n
            elif n <= second:
                second = n
            else:
                return True
        return False
