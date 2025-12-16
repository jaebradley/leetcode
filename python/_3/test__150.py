import pytest

from _150 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "tokens, expected",
        [
            (["4", "3", "-"], 1),
            (["-4", "-3", "+"], -7),
            (["-4", "-3", "-"], -1),
            (["2", "1", "+", "3", "*"], 9),
            (["4", "13", "5", "/", "+"], 6),
            (["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"], 22),
        ])
    def test(self, tokens, expected):
        assert Solution().evalRPN(tokens) == expected
