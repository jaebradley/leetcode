class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(" ")
        if len(words) != len(pattern):
            return False
        words_by_letter = {}
        letters_by_word = {}

        for current_index in range(len(words)):
            word = words[current_index]
            letter = pattern[current_index]

            word_associated_with_letter = words_by_letter.get(letter)
            letter_associated_with_word = letters_by_word.get(word)
            if None is word_associated_with_letter and None is letter_associated_with_word:
                words_by_letter[letter] = word
                letters_by_word[word] = letter
            elif word_associated_with_letter != word or letter_associated_with_word != letter:
                return False

        return True
