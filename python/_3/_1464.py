"""
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
"""

import heapq
import math
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        return math.prod(map(lambda value: value - 1, heapq.nlargest(2, nums)))
