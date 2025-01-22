import sys
from collections import Counter
from typing import List

"""
You are given an integer array nums. This array contains n elements, where exactly n - 2 elements are special numbers. 
One of the remaining two elements is the sum of these special numbers, and the other is an outlier.

An outlier is defined as a number that is neither one of the original special numbers nor the element representing the sum of those numbers.

Note that special numbers, the sum element, and the outlier must have distinct indices, but may share the same value.

Return the largest potential outlier in nums.
"""


class Solution:
    """
    Note that if n1 + n2 + n3...= Some Sum then n1 + n2 + n3...+ Some Sum = 2 x Some Sum

    Sum all the numbers, keep track of the frequency of the numbers via a dictionary.

    Iterate over the numbers again, and subtract each number from the sum, decrementing the number's frequency.

    Does the sum value / 2 exist in the dictionary? If so, then the sum / 2 is the sum element and the value subtracted is the
    outlier.

    Do this for all numbers, to get the largest potential outlier.
    """

    def getLargestOutlier(self, nums: List[int]) -> int:
        total_sum, number_frequency_by_value, outlier = 0, Counter(), -sys.maxsize
        for n in nums:
            total_sum += n
            number_frequency_by_value[n] += 1

        for potential_outlier in nums:
            remainder = total_sum - potential_outlier
            if 0 == (remainder % 2):
                number_frequency_by_value[potential_outlier] -= 1
                if number_frequency_by_value[remainder / 2]:
                    outlier = max(outlier, potential_outlier)
                number_frequency_by_value[potential_outlier] += 1

        return outlier
