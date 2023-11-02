from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        value = 0

        for n in nums:
            value ^= n

        return value
