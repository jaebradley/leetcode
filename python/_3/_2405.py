class Solution:
    def partitionString(self, s: str) -> int:
        counter, seen_characters = 1, set()
        for current_character in s:
            if current_character in seen_characters:
                seen_characters = set()
                counter += 1

            seen_characters.add(current_character)

        return counter
