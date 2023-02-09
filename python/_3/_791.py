"""
https://leetcode.com/problems/custom-sort-string/
"""


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        counts_by_character = {}
        for character in s:
            count = counts_by_character.get(character, 0)
            counts_by_character[character] = 1 + count

        result = []
        for character in order:
            if character in counts_by_character:
                for _ in range(counts_by_character.get(character, 0)):
                    result.append(character)

                del counts_by_character[character]

        for character, counts in counts_by_character.items():
            for _ in range(counts):
                result.append(character)

        return "".join(result)
