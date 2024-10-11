"""
https://leetcode.com/problems/valid-anagram/
"""


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counts_by_character = {}
        for c in s:
            counts_by_character.setdefault(c, 0)
            counts_by_character[c] += 1

        for c in t:
            counts_by_character.setdefault(c, 0)
            counts_by_character[c] -= 1

        for count in counts_by_character.values():
            if 0 != count:
                return False
        return True
