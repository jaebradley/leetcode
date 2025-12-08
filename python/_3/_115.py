"""
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.



Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
"""
from functools import lru_cache


class RecursiveSolution:
    """
    Subsequence = any characters in relative, but not necessarily exact, order that match t
    ba * number of ways to solve (bgbag, g)
    base case is single character t in a haystack of s - just count number of instances of t in s

    matches = 0
    for index, h in enumerate(haystack):
        for index, t in enumerate(target):
            if h == t:
                if t_index == len(target) - 1:
                    matches += 1
                suffix_matches = recursive(haystack[from h: to end], target[from t: to end])
                matches += suffix_matches

    return matches
    """

    def numDistinct(self, s: str, t: str) -> int:
        @lru_cache(maxsize=None)
        def check_matches_for_indices(haystack_index: int, target_index: int) -> int:
            # if the haystack index is greater than the size of the input string or the target index is greater than
            # the size of the input target, then return a match of 0 if the target index isn't the length of the target
            # string (i.e. the target string has been exhausted)
            if haystack_index >= len(s) or target_index >= len(t):
                return int(target_index == len(t))

            # Always check for matches for the next haystack index and the current target index
            matches = check_matches_for_indices(haystack_index + 1, target_index)
            if s[haystack_index] == t[target_index]:
                # if the current haystack character and target character are the same also check for matches for the
                # next haystack character and next target character
                matches += check_matches_for_indices(haystack_index + 1, target_index + 1)

            return matches

        return check_matches_for_indices(0, 0)


class IterativeSolution:
    """
    dp[starting haystack index][starting target index] = # of distinct subsequences starting at s[starting haystack index] and t[starting target index], respectively
    Base case is that dp[haystack index + 1][starting target index + 1] = 1 because an empty string is a subsequence of an empty string
    Then start going backwards - the subsequences of starting haystack index compared to starting target index is at least the subsequences
    at starting haystack index + 1, starting target index.
    If the characters are the same, add the subsequences at haystack index + 1, starting target index + 1 since we've found another valid subsequence.
    """
    def numDistinct(self, s: str, t: str) -> int:
        dp = [[0 for _ in range(len(t) + 1)] for _ in range(len(s) + 1)]
        for row in range(len(s) + 1):
            # empty string is a subsequence of an empty string
            dp[row][len(t)] = 1

        for haystack_index in range(len(s) - 1, -1, -1):
            for target_index in range(len(t) -1, -1, -1):
                dp[haystack_index][target_index] = dp[haystack_index + 1][target_index]
                if s[haystack_index] == t[target_index]:
                    dp[haystack_index][target_index] += dp[haystack_index + 1][target_index + 1]

        return dp[0][0]
