"""
https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
"""

class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        first_word_character_index = 0
        second_word_character_index = 0
        merged_words = ""

        while first_word_character_index < len(word1) and second_word_character_index < len(word2):
            if second_word_character_index < first_word_character_index:
                merged_words += word2[second_word_character_index]
                second_word_character_index += 1
            else:
                merged_words += word1[first_word_character_index]
                first_word_character_index += 1

        while first_word_character_index < len(word1):
            merged_words += word1[first_word_character_index]
            first_word_character_index += 1

        while second_word_character_index < len(word2):
            merged_words += word2[second_word_character_index]
            second_word_character_index += 1

        return merged_words