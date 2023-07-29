class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        starting_index, ending_index = 0, k - 1
        current_vowel_count = 0
        for c in s[0:ending_index + 1]:
            if c in vowels:
                current_vowel_count += 1
        max_vowel_count = current_vowel_count
        while ending_index < len(s) - 1:
            if s[starting_index] in vowels:
                current_vowel_count -= 1
            if s[1 + ending_index] in vowels:
                current_vowel_count += 1
            max_vowel_count = max(max_vowel_count, current_vowel_count)
            starting_index += 1
            ending_index += 1
        return max_vowel_count
