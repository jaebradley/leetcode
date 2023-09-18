from typing import List


class Solution:
    CHARACTERS_BY_DIGIT = {
        "2": ["a", "b", "c"],
        "3": ["d", "e", "f"],
        "4": ["g", "h", "i"],
        "5": ["j", "k", "l"],
        "6": ["m", "n", "o"],
        "7": ["p", "q", "r", "s"],
        "8": ["t", "u", "v"],
        "9": ["w", "x", "y", "z"]
    }

    def letterCombinations(self, digits: str) -> List[str]:
        if "" == digits:
            return []
        return self.helper(prefixes=[""], remaining_digits=list(digits))

    def helper(self, prefixes: List[str], remaining_digits: List[str]) -> List[str]:
        if remaining_digits:
            next_remaining_digit = remaining_digits.pop(0)
            characters = Solution.CHARACTERS_BY_DIGIT[next_remaining_digit]

            next_prefixes = []
            for prefix in prefixes:
                for character in characters:
                    next_prefixes.append(prefix + character)

            return self.helper(next_prefixes, remaining_digits)

        return prefixes
