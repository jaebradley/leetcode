class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_counts_by_letter = self.counts_by_letter(word=magazine)
        for letter in ransomNote:
            if 0 == magazine_counts_by_letter.get(letter, 0):
                return False

            magazine_counts_by_letter[letter] -= 1

        return True

    def counts_by_letter(self, word: str):
        value = {}

        for letter in word:
            counts = value.get(letter, 0)
            value[letter] = 1 + counts

        return value