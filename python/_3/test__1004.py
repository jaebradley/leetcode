import pytest

from _1004 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2], 6),
            ([[0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], 3], 10)
        ])
    def test(self, inputs, expected):
        assert Solution().longestOnes(*inputs) == expected
