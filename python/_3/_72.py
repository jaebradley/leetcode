class Solution:
    """
    2D matrix where each dimension is the length of the word.
    Matrix[i][j] represents the minimum number of operations to get word1[0:i] to equal word2[0:j].
    Start from i = 0 and j = 0.
    If word1[i] == word2[j] then the characters are the same and no operation is necessary.
    If the characters are different, need to get the minimum of insertion, replace, or deletion.
    To insert, look at Matrix[i][j - 1].
    To replace, look at Matrix[i - 1][j - 1].
    To delete, look at Matrix[i - 1][j].
    1 + minimum of these three values represents the minimum operations for the given i and j values.
    The last matrix value, "the bottom right", should represent the minimum operations needed to convert the two words.

    Need to initialize matrix where first row / first column values are the character index. In other words,
    if the comparison word was empty, it'd take 1 operation if the other word was 1 character long, and 2 operations
    if the other word was 2 characters long, etc.
    """

    def minDistance(self, word1: str, word2: str) -> int:
        first_word_length, second_word_length = len(word1), len(word2)
        matrix = list(map(lambda row: [0] * (1 + first_word_length), range(1 + second_word_length)))

        for first_word_index in range(1 + first_word_length):
            matrix[0][first_word_index] = first_word_index
        for second_word_index in range(1 + second_word_length):
            matrix[second_word_index][0] = second_word_index

        for second_word_index in range(1, len(matrix)):
            row = matrix[second_word_index]
            for first_word_index in range(1, len(row)):
                first_word_character, second_word_character = word1[first_word_index - 1], word2[second_word_index - 1]
                if first_word_character == second_word_character:
                    row[first_word_index] = matrix[second_word_index - 1][first_word_index - 1]
                else:
                    row[first_word_index] = 1 + min(
                        matrix[second_word_index - 1][first_word_index],
                        matrix[second_word_index - 1][first_word_index - 1],
                        matrix[second_word_index][first_word_index - 1]
                    )

        return matrix[-1][-1]
