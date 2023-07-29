import pytest

from _1456 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["abciiidef", 3], 3),
            (["aeiou", 2], 2),
            (["leetcode", 3], 2),
        ])
    def test(self, inputs, expected):
        assert Solution().maxVowels(*inputs) == expected
