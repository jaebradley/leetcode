import pytest

from _312 import TopDownSolution, BottomUpSolution


class TestSolution:
    @pytest.mark.parametrize(
        "coins, expected",
        [
            ([3, 1, 5, 8], 167),
            ([1, 5], 10),
        ])
    def test(self, coins, expected):
        for solution in (TopDownSolution(), BottomUpSolution()):
            assert expected == solution.maxCoins(coins)
