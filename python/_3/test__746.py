import pytest

from _746 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([10, 15, 20], 15),
            ([1, 100, 1, 1, 1, 100, 1, 1, 100, 1], 6),
        ])
    def test(self, input, expected):
        assert Solution().minCostClimbingStairs(input) == expected
