"""
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.
"""


class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        while 1 < n:
            if 0 != n % 3:
                return False
            n /= 3

        return 1 == n