import sys
from typing import List


class Solution:
    """
    Keep track of prefix, keep track of current sum, keep track of max sum.
    Start at beginning of array.
    prefix = 0, current sum = first element of array, max sum = first element of array
    Add current element to prefix, and add next element to current sum, check updated current sum against the max sum
    If prefix ever is negative, set prefix to 0 and current sum to next element
    Max sum at end of evaluating all elements should represent max subarray
    """

    def maxSubArray(self, nums: List[int]) -> int:
        prefix, max_sum = -sys.maxsize, nums[0]
        for value in nums:
            prefix = max(value, prefix + value)
            max_sum = max(max_sum, prefix)
        return max_sum
