"""
https://leetcode.com/problems/is-subsequence/
"""


class Solution:
    """
    Iterate over t.
    For each character in t, check if character matches character in s, at the current character index of s.
    If character matches increment the index for t and the index for s.
    If the index for t is < length of t and index for s equals the length of s, then s is a subsequence of t.
    If the index for t is >= length of t and index for s < length of s, then s is not a subsequence of t.
    """

    def isSubsequence(self, s: str, t: str) -> bool:
        t_index = s_index = 0
        while t_index < len(t) and s_index < len(s):
            if t[t_index] == s[s_index]:
                s_index += 1
            t_index += 1

        return s_index == len(s)
