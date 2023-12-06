from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        common_prefix = ""

        for character_index in range(200):
            current_character = None
            for s in strs:
                if character_index >= len(s):
                    return common_prefix
                elif current_character is None:
                    current_character = s[character_index]
                elif current_character != s[character_index]:
                    return common_prefix

            common_prefix += current_character

        return common_prefix
