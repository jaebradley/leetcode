import pytest

from _122 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[7, 1, 5, 3, 6, 4]], 7),
            ([[1, 2, 3, 4, 5]], 4),
            ([[7, 6, 4, 3, 1]], 0),
        ])
    def test(self, arguments, expected):
        assert Solution().maxProfit(*arguments) == expected
