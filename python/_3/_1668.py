class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        max_iterations = int(1 + (len(sequence) / len(word)))
        for i in range(1, 1 + max_iterations):
            if i * word not in sequence:
                return i - 1

        raise ValueError("should never get here")
