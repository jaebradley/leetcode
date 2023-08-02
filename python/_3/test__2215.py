import pytest

from _2215 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3], [2, 4, 6]], [[1, 3], [4, 6]]),
            ([[1, 2, 3, 3], [1, 1, 2, 2]], [[3], []]),
            ([[1], [1]], [[], []]),
        ])
    def test(self, inputs, expected):
        assert Solution().findDifference(*inputs) == expected
