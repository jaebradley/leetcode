import pytest

from _13 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "roman, expected",
        [
            ("III", 3),
            ("LVIII", 58),
            ("MCMXCIV", 1994),
            ("MCDLXXVI", 1476)
        ])
    def test(self, roman, expected):
        assert Solution().romanToInt(roman) == expected
