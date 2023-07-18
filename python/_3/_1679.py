"""
https://leetcode.com/problems/max-number-of-k-sum-pairs/
"""

from typing import List


class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        operations_count = 0
        counts_by_complement = dict()
        for current_number in nums:
            current_number_complement_count = counts_by_complement.get(current_number, 0)
            if 0 < current_number_complement_count:
                operations_count += 1
                counts_by_complement[current_number] -= 1
            else:
                complement = k - current_number
                complement_count = counts_by_complement.get(complement, 0)
                counts_by_complement[complement] = 1 + complement_count
        return operations_count
