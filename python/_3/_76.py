from collections import Counter


class Solution:
    """
    Two pointers - left and right index.
    Keep adding characters to candidate string until all characters in t have been accounted for.
    Keep removing characters from the left side of the string until all characters in t have NOT been accounted for.
    Start adding characters from the right side of the input string, etc, until last character is processed.
    """

    def minWindow(self, s: str, t: str) -> str:
        remaining_character_counts, character_counts = len(t), Counter(t)
        left_index = minimum_left_index = minimum_right_index = 0
        for current_character_index, current_character in enumerate(s, 1):
            remaining_character_counts -= character_counts[current_character] > 0
            character_counts[current_character] -= 1

            if not remaining_character_counts:
                while left_index < current_character_index and character_counts[s[left_index]] < 0:
                    character_counts[s[left_index]] += 1
                    left_index += 1

                if not minimum_right_index \
                        or (current_character_index - left_index) <= (minimum_right_index - minimum_left_index):
                    minimum_left_index, minimum_right_index = left_index, current_character_index

        return s[minimum_left_index:minimum_right_index]
