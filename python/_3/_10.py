"""
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
"""
from collections import defaultdict


class TopDownSolution:
    """
    dp[string index][pattern index] = boolean
    Boolean value represents if the string from index 0 to the string index is valid for the pattern from index 0 to the pattern index.
    Memoize the value for a string index / pattern index combination so it is not calculated again.
    Recursively check different patterns
    * {character}* can mean if there are 0+ instances of the character.
      * So call the dp function for the current string index + the next pattern (0 instances)
      * OR if the character matches the current character, keep the pattern index value the same, but advance the string index to the next character to see if there's a match there
    Runtime: O(# of characters in text x # of characters in pattern)
    Memory: O(# of characters in text x # of characters in pattern)
    """

    def isMatch(self, s: str, p: str) -> bool:
        pattern_indices_by_string_index = defaultdict(dict)

        def dp(string_index, pattern_index) -> bool:
            if pattern_index not in pattern_indices_by_string_index[string_index]:
                if pattern_index == len(p):
                    answer = len(s) == string_index
                else:
                    current_letter_match = string_index < len(s) and (s[string_index] == p[pattern_index] or p[pattern_index] == ".")
                    if pattern_index < len(p) - 1 and p[pattern_index + 1] == "*":
                        answer = dp(string_index, pattern_index + 2) or (current_letter_match and dp(string_index + 1, pattern_index))
                    else:
                        answer = current_letter_match and dp(string_index + 1, pattern_index + 1)

                pattern_indices_by_string_index[string_index][pattern_index] = answer

            return pattern_indices_by_string_index[string_index][pattern_index]

        return dp(0, 0)


class BottomUpSolution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        dp[-1][-1] = True

        for string_index in range(len(s), -1, -1):
            for pattern_index in range(len(p) - 1, -1, -1):
                exact_character_match = string_index < len(s) and (p[pattern_index] == s[string_index] or p[pattern_index] == ".")
                if pattern_index < len(p) - 1 and p[pattern_index + 1] == "*":
                    dp[string_index][pattern_index] = dp[string_index][pattern_index + 2] or (exact_character_match and dp[string_index + 1][pattern_index])
                else:
                    dp[string_index][pattern_index] = exact_character_match and dp[string_index + 1][pattern_index + 1]

        return dp[0][0]
