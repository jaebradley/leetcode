"""
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
"""
import math
from typing import List


class Solution:
    """
    Identify the minimum banana eating rate such that all the bananas are eaten in h hours.
    If a pile has less than k bananas, then no other piles will be started.

    Max pile value // h?
    Max pile value = len(piles)
    [1, 1, 1, 1]
    math.ceil(a / k) + math.ceil(b / k) ... = h
    k such that sum([a // k, b // k, c // k, d // k, etc]) = h
    sum(a, b, c, d, ) = h x k
    math.ceil(sum(a, b, c, d, ) / h) = k
    """
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        while left < right:
            mid = (left + right) // 2
            hours = sum(map(lambda pile: math.ceil(pile / mid), piles))

            if hours <= h:
                right = mid
            else:
                left = mid + 1

        return right
