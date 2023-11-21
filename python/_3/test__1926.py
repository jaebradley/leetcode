import pytest

from _1926 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]], [1, 2]], 1),
            ([[["+", "+", "+"], [".", ".", "."], ["+", "+", "+"]], [1, 0]], 2),
            ([[[".", "+"]], [0, 0]], -1),
        ])
    def test(self, arguments, expected):
        assert Solution().nearestExit(*arguments) == expected
