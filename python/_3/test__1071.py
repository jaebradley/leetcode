import pytest

from _1071 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["ABCABC", "ABC"], "ABC"),
            (["ABABAB", "ABAB"], "AB"),
            (["BBBBB", "BBBBB"], "BBBBB"),
            (["LEET", "CODE"], ""),
        ])
    def test(self, inputs, expected):
        assert Solution().gcdOfStrings(*inputs) == expected
