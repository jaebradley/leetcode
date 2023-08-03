from typing import Dict

"""
In order for strings to be close, they must have the same set of characters and the same (relative) character counts 
(for the transformation operation).
"""


class Solution:
    def calculate_character_counts(self, word) -> Dict[str, int]:
        counts_by_character = {}

        for c in word:
            count = counts_by_character.get(c, 0)
            counts_by_character[c] = 1 + count

        return counts_by_character

    def closeStrings(self, word1: str, word2: str) -> bool:
        first_word_counts = self.calculate_character_counts(word1)
        second_word_counts = self.calculate_character_counts(word2)
        return first_word_counts.keys() == second_word_counts.keys() \
            and sorted(first_word_counts.values()) == sorted(second_word_counts.values())
