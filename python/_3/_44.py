"""
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.


Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
"""
from functools import lru_cache


class RecursiveSolution:
    """
    Runtime: O(# number of characters in s x # of characters in p)
    Space: O(# number of characters in s x # of characters in p)
    """
    def isMatch(self, s: str, p: str) -> bool:
        def remove_duplicate_stars(p: str) -> str:
            new_string = []
            for char in p:
                if not new_string or char != "*":
                    new_string.append(char)
                elif new_string[-1] != "*":
                    new_string.append(char)
            return "".join(new_string)

        @lru_cache(maxsize=None)
        def verify_match(string, pattern):
            if string == pattern or pattern == "*":
                return True

            if not string or not pattern:
                return False

            if pattern[0] == string[0] or pattern[0] == "?":
                return verify_match(string[1:], pattern[1:])

            if pattern[0] == "*":
                return verify_match(string, pattern[1:]) or verify_match(string[1:], pattern)

            return False

        return verify_match(s, remove_duplicate_stars(p))

class IterativeSolution:
    """
    dp[string index][pattern index] = True/False indicates whether the string up to the string index value matches the
    pattern up to the pattern index value.

    Base cases:
    "" only matches "*"
    "<any character>" always matches "?"

    When matching "*" there are three possibilities:
    1. Matching 0 characters
    3. Matching many characters

    Sub-problems:
    if s[0] and p[0] match, then sub-problem is if s[1:] and p[1:] match.

    return dp[string length - 1][pattern length - 1]
    """
    def isMatch(self, s: str, p: str) -> bool:
        raise NotImplementedError()