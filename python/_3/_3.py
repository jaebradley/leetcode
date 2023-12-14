class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen_characters = set([])
        left_index, right_index, longest_length = 0, 0, 0

        while right_index < len(s):
            current_character = s[right_index]
            while current_character in seen_characters:
                seen_characters.remove(s[left_index])
                left_index += 1

            seen_characters.add(current_character)
            longest_length = max(longest_length, right_index - left_index + 1)

            right_index += 1

        return longest_length
