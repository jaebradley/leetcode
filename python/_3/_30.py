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

    Can re-use previous solutions - trivial example is "aaaaa", ["a, "a, "a] where you can keep track of the words
    seen starting at an index and see if they are re-used again
    """

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        target_string_length, word_size, total_words_length, indices = len(s), len(words[0]), len("".join(words)), []
        counts_by_word = Counter(list(words))

        for starting_index in range(0, word_size):
            # Since the sliding window will identify all substrings for a given offset, we really only need to consider
            # all offsets that are within the range of modulo word_size
            self.sliding_window(s, starting_index, indices, word_size, counts_by_word)

        return indices

    def sliding_window(self, input: str,
                       starting_index: int,
                       results: list[int],
                       word_size: int,
                       original_counts_by_word: Counter[str]) -> None:
        counts_by_word = original_counts_by_word.copy()
        starting_word_index = starting_index
        for current_index in range(starting_index, len(input), word_size):
            current_word = input[current_index:current_index + word_size]
            count = counts_by_word.get(current_word, None)
            if count is not None:
                # If a word matches, decrement the counts for this word
                counts_by_word[current_word] -= 1
                all_values_are_zero = all(map(lambda x: x == 0, counts_by_word.values()))
                any_value_is_negative = any(map(lambda x: x < 0, counts_by_word.values()))
                # If all word counts are zero, we have a matching substring and we can "log" the starting word index
                if all_values_are_zero:
                    results.append(starting_word_index)
                    # Make sure to start the next potential starting word at the next word after the current starting word
                    next_starting_word_index = starting_word_index + word_size
                    starting_word = input[starting_word_index: next_starting_word_index]
                    # Increment the count of the current starting word, since we're "sliding" to the right now
                    counts_by_word[starting_word] += 1
                    starting_word_index = next_starting_word_index
                # if a count is negative, that means we've counted too much, so we need to slide our left index to the
                # right until no counts are negative.
                # Since we have a matching word, we don't necessarily want to reset our counts, but we will have to
                # reset our starting word index
                elif any_value_is_negative:
                    # slide the left side until the left-most index is at a starting word where the word counts are
                    # all non-zero
                    for left_index in range(starting_word_index, current_index + word_size, word_size):
                        starting_word_index = left_index
                        if all(map(lambda x: x >= 0, counts_by_word.values())):
                            break
                        counts_by_word[input[left_index: left_index + word_size]] += 1
            # if no word matches, reset the starting word index and counts
            else:
                counts_by_word = original_counts_by_word.copy()
                starting_word_index = current_index + word_size
