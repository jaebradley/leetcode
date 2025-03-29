import pytest

from _15 import Solution, TwoPointerSolution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
            ([0, 1, 1], []),
            ([0, 0, 0], [[0, 0, 0]]),
            ([-2, 0, 1, 1, 2], [[-2, 0, 2], [-2, 1, 1]]),
        ])
    def test(self, input, expected):
        for solution in [Solution(), TwoPointerSolution()]:
            assert sorted(solution.threeSum(input)) == sorted(expected)
