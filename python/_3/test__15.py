import pytest

from _15 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
            ([0, 1, 1], []),
            ([0, 0, 0], [[0, 0, 0]]),
        ])
    def test(self, input, expected):
        assert sorted(Solution().threeSum(input)) == sorted(expected)
