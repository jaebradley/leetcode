import pytest

from _2300 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[5, 1, 3], [1, 2, 3, 4, 5], 7], [4, 0, 3]),
            ([[3, 1, 2], [8, 5, 8], 16], [2, 0, 2]),
        ])
    def test(self, inputs, expected):
        assert Solution().successfulPairs(*inputs) == expected
