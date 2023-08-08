import pytest

from _2390 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["leet**cod*e"], "lecoe"),
            (["erase*****"], ""),
        ])
    def test(self, inputs, expected):
        assert Solution().removeStars(*inputs) == expected
