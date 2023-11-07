class Solution:
    """
    A subsequence of a string is a new string generated from the original string with some characters (can be none)
    deleted without changing the relative order of the remaining characters.

    "ace" is a subsequence of "abcde".

    Can think of the LCS at index A for the first word and index B for the second word (LCS(A, B)
    as 1 + the LCS at index A - 1 and index B - 1 (if the character at index A == the character at index B)
    OR the maximum LCS between index A and index B - 1 and index A - 1 and index B.
    """
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        current_row = [0] * (len(text1) + 1)
        for second_word_character in text2:
            next_row = [0] * (len(text1) + 1)
            for first_word_index in range(1, len(text1) + 1):
                first_word_character = text1[first_word_index - 1]

                if second_word_character == first_word_character:
                    next_subsequence_count = 1 + current_row[first_word_index - 1]
                else:
                    next_subsequence_count = max(current_row[first_word_index], next_row[first_word_index - 1])
                next_row[first_word_index] = next_subsequence_count

            current_row = next_row

        return current_row[-1]
