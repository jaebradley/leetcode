"""
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
"""

class Solution:
    """
    All single characters are palindromes.
    Check if any of the two character combinations are a palindrome.
    For each of the three (and longer) character combinations, use DP array to check if palindrome.
    Check if edge characters are the same, and then check if the inner characters are a palindrome.
    """
    def countSubstrings(self, s: str) -> int:
        count = len(s)
        dp = [None] * len(s)
        for character_index in range(len(s)):
            dp[character_index] = [False] * len(s)
            dp[character_index][character_index] = True

        for character_index in range(1, len(s)):
            if s[character_index - 1] == s[character_index]:
                dp[character_index - 1][character_index] = True
                count += 1

        for string_length in range(3, len(s) + 1):
            for starting_character_index in range(len(s) - string_length + 1):
                ending_character_index = starting_character_index + string_length - 1
                if s[ending_character_index] == s[starting_character_index] and dp[starting_character_index + 1][ending_character_index - 1]:
                    dp[starting_character_index][ending_character_index] = True
                    count += 1

        return count