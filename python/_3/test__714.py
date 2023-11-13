import pytest

from _714 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[1, 3, 2, 8, 4, 9], 2], 8),
            ([[1, 3, 7, 5, 10, 3], 3], 6),
        ])
    def test(self, arguments, expected):
        assert Solution().maxProfit(*arguments) == expected
