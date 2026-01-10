"""
You are given a string s and a pattern string p, where p contains exactly one '*' character.

The '*' in p can be replaced with any sequence of zero or more characters.

Return true if p can be made a substring of s, and false otherwise.

Example 1:
Input: s = "leetcode", p = "ee*e"
Output: true
Explanation:
By replacing the '*' with "tcod", the substring "eetcode" matches the pattern.

Example 2:
Input: s = "car", p = "c*v"
Output: false
Explanation:
There is no substring matching the pattern.

Example 3:
Input: s = "luck", p = "u*"
Output: true
Explanation:
The substrings "u", "uc", and "uck" match the pattern.

Constraints:

1 <= s.length <= 50
1 <= p.length <= 50
s contains only lowercase English letters.
p contains only lowercase English letters and exactly one '*'
"""
from collections import Counter


class Solution:
    """
    Approach:
    Since there's only one * character, split on this character.
    The first part of the pattern must match a substring starting from the left side of s, and the second part of the
    pattern must match a substring starting from the right side of s.
    Use two pointers to check for matches from both ends until they meet.
    If these two parts overlap, then there's no valid substring that can match the pattern.
    Once a match is found for a part, stop moving the pointer associated with that part.
    The first part pointer starts moves from left to right, starting from the start of the input string.
    The second part ponter starts from right to left, starting from the end of the input string.
    Runtime: O(length of s x length of p))
    Space complexity: O(1)
    """
    def hasMatch(self, s: str, p: str) -> bool:
        first_part, second_part = p.split('*')
        first_part_starting_index, second_part_starting_index = 0, len(s) - len(second_part)
        while first_part_starting_index + len(first_part) <= second_part_starting_index:
            matching_first_part = s[first_part_starting_index:first_part_starting_index + len(first_part)] == first_part
            matching_second_part = s[second_part_starting_index:second_part_starting_index + len(second_part)] == second_part
            if matching_first_part and matching_second_part:
                return True

            if not matching_first_part:
                first_part_starting_index += 1

            if not matching_second_part:
                second_part_starting_index -= 1

        return False

