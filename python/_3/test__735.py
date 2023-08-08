import pytest

from _735 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[5, 10, -5]], [5, 10]),
            ([[8, -8]], []),
            ([[8, -8]], []),
            ([[-8, 8]], [-8, 8]),
            ([[-8, -8]], [-8, -8]),
            ([[10, 2, -5]], [10]),
            ([[-2, -2, 1, -2]], [-2, -2, -2]),
            ([[-2, 2, 1, -2]], [-2]),
        ])
    def test(self, inputs, expected):
        assert Solution().asteroidCollision(*inputs) == expected
