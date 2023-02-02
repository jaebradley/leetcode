"""
https://leetcode.com/problems/longest-repeating-character-replacement/description/
"""


class Solution:
    """
    Start index and end index for window (while the window doesn't hit the end of the string)

    Keep track of the character frequencies seen in the window
    If the window contains a valid substring, increase the end index value
    If the window does not contain a valid substring, increase the start index value (decrement character count for old start character)
    A valid substring occurs when end index + 1 - start index - max character frequency <= k (non-same character count <= k)
    Keep track of the max character frequency seen yet
    Diff between end and start indices is the longest window possible
    """

    def characterReplacement(self, s: str, k: int) -> int:
        start_index = 0
        end_index = 0
        character_frequencies = {}
        max_character_frequency = 0

        for end_index in range(0, len(s)):
            current_character = s[end_index]
            current_character_frequency = character_frequencies.get(current_character, 0)
            next_character_frequency = current_character_frequency + 1
            character_frequencies[current_character] = next_character_frequency
            max_character_frequency = max(max_character_frequency, next_character_frequency)
            if end_index + 1 - start_index - max_character_frequency > k:
                starting_character = s[start_index]
                character_frequencies[starting_character] -= 1
                start_index += 1

        return end_index + 1 - start_index
