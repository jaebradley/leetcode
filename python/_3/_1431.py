"""
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
"""

from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_candy_value = max(candies)
        result = []
        for candy in candies:
            result.append((candy + extraCandies) >= max_candy_value)

        return result
