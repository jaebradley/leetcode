import pytest

from _643 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 12, -5, -6, 50, 3], 4], 12.75),
            ([[5], 1], 5),
        ])
    def test(self, inputs, expected):
        assert Solution().findMaxAverage(*inputs) == expected
