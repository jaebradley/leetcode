import pytest

from _452 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[10, 16], [2, 8], [1, 6], [7, 12]], 2),
            ([[1, 2], [3, 4], [5, 6], [7, 8]], 4),
            ([[1, 2], [2, 3], [3, 4], [4, 5]], 2),
        ])
    def test(self, inputs, expected):
        assert Solution().findMinArrowShots(inputs) == expected
