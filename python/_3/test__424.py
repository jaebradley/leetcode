import pytest

from _424 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["ABAB", 2], 4),
            (["AABABBA", 1], 4)
        ])
    def test(self, inputs, expected):
        assert Solution().characterReplacement(*inputs) == expected
