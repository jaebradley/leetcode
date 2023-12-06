class Solution:
    INTEGERS_BY_ROMAN_NUMERAL = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }

    def romanToInt(self, s: str) -> int:
        sum = 0

        for current_index, current_roman_numeral in enumerate(s[:-1]):
            current_integer = Solution.INTEGERS_BY_ROMAN_NUMERAL.get(current_roman_numeral)
            next_integer = Solution.INTEGERS_BY_ROMAN_NUMERAL.get(s[1 + current_index])
            if current_integer >= next_integer:
                sum += current_integer
            else:
                sum -= current_integer

        return sum + Solution.INTEGERS_BY_ROMAN_NUMERAL.get(s[-1])
