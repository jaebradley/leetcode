"""
https://leetcode.com/problems/ones-and-zeroes/
"""

from typing import List

class Solution:
    """
    For each input string, dp[m][n] for that input string is the length of that input string.
    """
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int: