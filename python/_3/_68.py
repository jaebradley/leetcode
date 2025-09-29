from typing import List

"""
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
"""

class Solution:
    """
    Process words line by line.
    For the current line, the total line length = # of characters + (# of words - 1) spaces
    If the next word can't be added to the current line without exceeding the max length, build the line.
    All words get (maxWidth - total word characters) // (total words - 1) spaces (rounded down).
    The first N words get an extra space where N is the remainder of (maxWidth - total word characters) // (total words - 1).
    Special cases are where a line is composed of exactly one word. This case is identical to where a line is the last line.

    Runtime analysis: O(# of words x average length of word)
    Outer for loop executes once per word. Each word is only iterated over once (at most) by outer for loop.
    On average, can fit maxWidth / # of words on each line. Each line iteration costs, at most, O(max width).
    So on average, each line iteration will cost O(average length of word)
    """
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        results = []
        current_lines_words, current_character_count = [], 0
        for current_word in words:
            current_word_length = len(current_word)
            next_total_line_length = current_character_count + current_word_length + len(current_lines_words)
            if next_total_line_length > maxWidth:
                results.append(self.format_line(line=current_lines_words, is_last_line=False, max_width=maxWidth))

                current_lines_words = []
                current_character_count = 0

            current_lines_words.append(current_word)
            current_character_count += current_word_length

        if len(current_lines_words):
            results.append(self.format_line(line=current_lines_words, is_last_line=True, max_width=maxWidth))

        return results

    def format_line(self, line: list[str], is_last_line: bool, max_width: int) -> str:
        # -1 to cancel out last word's space
        line_length = -1 + sum(map(lambda word: 1 + len(word), line))
        spaces = max_width - line_length

        if len(line) == 1 or is_last_line:
            return " ".join(line) + " " * spaces

        word_count = len(line) - 1
        spaces_per_word = spaces // word_count
        additional_spaces = spaces % word_count

        for word_index in range(additional_spaces):
            line[word_index] += " "

        for word_index in range(word_count):
            line[word_index] += " " * spaces_per_word

        return  " ".join(line)