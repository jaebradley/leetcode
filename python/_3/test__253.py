import pytest

from _253 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "intervals, expected",
        [
            ([[0,30],[5,10],[15,20]], 2),
            ([[7,10],[2,4]], 1),
        ]
    )
    def test(self, intervals, expected):
        assert Solution().minMeetingRooms(intervals) == expected
