from typing import List


class Solution:
    """
    There are two cases:
    1. Maximum sub-array is non-circular (Problem #53)
    2. Maximum sub-array is circular

    In the second case, can think of the two "pieces" of the circular sub-array are split by a middle "piece" that is a
    "minimum" sub-array (if the middle "piece" was not a "minimum" sub-array then it would be a net positive sub-array
    and would be part of tha "maximum" sub-array).

    In other words,
    Array = [prefix of the maximum sub-array..., minimum sub-array..., suffix of the maximum sub-array...]
    So the maximum sub-array sum is the Total Sum of the Array - Sum of Minimum Sub-Array.
    """

    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        min_sum, current_min, max_sum, current_max, total = nums[0], 0, nums[0], 0, 0
        for value in nums:
            current_max = max(current_max + value, value)
            max_sum = max(max_sum, current_max)

            current_min = min(current_min + value, value)
            min_sum = min(min_sum, current_min)

            total += value

        if max_sum > 0:
            return max(max_sum, total - min_sum)

        # all negative values case
        return max_sum
