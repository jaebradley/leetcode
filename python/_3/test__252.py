import pytest

from _252 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "intervals, expected",
        [
            ([[0, 30], [5, 10], [15, 20]], False),
            ([[7, 10], [2, 4]], True),
            ([[1, 1]], True),
            ([[1, 1], [2, 2], [3, 3]], True),
            ([[1, 1], [2, 3], [3, 3]], True),
            ([[3, 3], [1, 3], [2, 3]], False),
        ])
    def test(self, intervals, expected):
        assert Solution().canAttendMeetings(intervals) == expected
