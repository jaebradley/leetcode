import pytest

from _17 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["23"], ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]),
            ([""], []),
            (["2"], ["a", "b", "c"]),
        ])
    def test(self, inputs, expected):
        assert Solution().letterCombinations(*inputs) == expected
