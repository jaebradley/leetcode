"""
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
"""
from collections import deque
class Solution:
    """
    Every character is a palindrome (of length 1).
    Check for all two-character palindromes.
    Iterate over the palindromes and see if
    1. They are longer than the current longest palindrome. If they are, make them the longest palindrome.
    2. Check to see if character before and after current string are the same. If they are, then the result is a new
       palindrome.
    """
    def longestPalindrome(self, s: str) -> str:
        palindromes, longest_palindrome = deque([]), (0, 0)
        for index in range(len(s)):
            palindromes.appendleft((index, index))

            if index + 1 < len(s) and s[index] == s[index + 1]:
                palindromes.appendleft((index, index + 1))

        while palindromes:
            current_palindrome = palindromes.pop()
            if current_palindrome[1] - current_palindrome[0] > longest_palindrome[1] - longest_palindrome[0]:
                longest_palindrome = current_palindrome

            if current_palindrome[0] > 0 and current_palindrome[1] < len(s) - 1 and s[current_palindrome[0] - 1] == s[current_palindrome[1] + 1]:
                palindromes.appendleft((current_palindrome[0] - 1, current_palindrome[1] + 1))

        return s[longest_palindrome[0]:longest_palindrome[1] + 1]