"""
An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

Given an integer n, return true if n is an ugly number.
"""

class Solution:
    def isUgly(self, n: int) -> bool:
        if 0 >= n:
            return False

        if 1 == n:
            return True

        if 0 == n % 2:
            return self.isUgly(n=n/2)

        if 0 == n % 3:
            return self.isUgly(n=n/3)

        if 0 == n % 5:
            return self.isUgly(n=n/5)

        return False
