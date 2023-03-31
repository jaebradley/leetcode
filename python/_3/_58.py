"""
https://leetcode.com/problems/length-of-last-word/
"""


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        first_non_space_character_index = None
        last_non_space_character_index = None

        for current_character_index in range(len(s) - 1, -1, -1):
            current_character = s[current_character_index]
            if " " == current_character:
                if first_non_space_character_index is not None and last_non_space_character_index is not None:
                    break

            else:
                if last_non_space_character_index is None:
                    last_non_space_character_index = current_character_index
                first_non_space_character_index = current_character_index
        return last_non_space_character_index - first_non_space_character_index + 1
