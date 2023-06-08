import pytest

from _2359 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[2, 2, 3, -1], 0, 1], 2),
            ([[1, 2, -1], 0, 2], 2),
            ([[4, 4, 8, -1, 9, 8, 4, 4, 1, 1], 5, 6], 1),
        ])
    def test(self, inputs, expected):
        assert Solution().closestMeetingNode(*inputs) == expected
