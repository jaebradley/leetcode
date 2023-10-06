import pytest

from _435 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "intervals, expected",
        [
            ([[1, 2], [2, 3], [3, 4], [0, 4]], 1),
            ([[1, 2], [2, 3], [3, 4], [1, 3]], 1),
            ([[1, 2], [1, 2], [1, 2]], 2),
            ([[1, 2], [2, 3]], 0),
        ])
    def test(self, intervals, expected):
        assert Solution().eraseOverlapIntervals(intervals) == expected
