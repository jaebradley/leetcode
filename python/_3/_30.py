from collections import Counter
from typing import List

"""
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all 
concatenated strings. 

"acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.

Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
"""


class Solution:
    """
    Sub-problem: if word is found from index x to x + n, then we need to see if there's a word from index x + n using
    the remaining words (and so on and so forth).

    Words are all the same length, so we don't have to worry about sub-strings.
    We know what the concatenated string length should be too - length of all the words together.
    So we can start from index 0 and iterate over the string one index at a time, recalculating for each starting index.

    O((target word length / (number of words x word length)) * number of words) -> O(target word length / word length)
    """

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        target_string_length, total_concatenated_string_length, indices = len(s), len("".join(words)), []
        counts_by_word = Counter(list(words))

        for starting_index in range(0, target_string_length - total_concatenated_string_length + 1):
            ending_index = starting_index + total_concatenated_string_length
            if self.has_substring(
                    s[starting_index:ending_index], counts_by_word):
                indices.append(starting_index)

        return indices

    def has_substring(self, substring, counts_by_word: Counter[str]) -> bool:
        for word, count in counts_by_word.items():
            if count > 0 and substring.startswith(word):
                counts_by_word[word] -= 1
                result = self.has_substring(substring[len(word):], counts_by_word)
                counts_by_word[word] += 1

                if result is True:
                    return True
        return substring == "" and sum(counts_by_word.values()) == 0
