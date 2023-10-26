import pytest

from _739 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "intervals, expected",
        [
            ([73, 74, 75, 71, 69, 72, 76, 73], [1, 1, 4, 2, 1, 1, 0, 0]),
            ([5, 4, 3, 2, 1], [0, 0, 0, 0, 0]),
        ])
    def test(self, intervals, expected):
        assert Solution().dailyTemperatures(intervals) == expected
