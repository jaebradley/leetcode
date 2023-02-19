import pytest

from _2497 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3, 4, 10, -10, -20], [[0, 1], [1, 2], [1, 3], [3, 4], [3, 5], [3, 6]], 2], 16),
            ([[-5], [], 0], -5),
            ([[-1], [], 1], -1),
            ([[1, -8, 0], [[1, 0], [2, 1]], 2], 1),
            ([[-2, -1, -2], [[0, 2]], 1], -1),
        ])
    def test(self, inputs, expected):
        assert Solution().maxStarSum(*inputs) == expected
