import pytest

from _84 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "heights, expected",
        [
            ([2, 1, 5, 6, 2, 3], 10),
            ([2, 4], 4),
            ([1, 1, 4, 1, 1], 5),
            ([1, 2, 3, 2, 1], 6),
            ([1, 2, 3, 4, 5], 9),
        ])
    def test(self, heights, expected):
        assert Solution().largestRectangleArea(heights) == expected
