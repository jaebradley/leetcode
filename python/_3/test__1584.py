import pytest

from _1584 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]], 20),
            ([[[3, 12], [-2, 5], [-4, 1]]], 18),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().minCostConnectPoints(*inputs)
