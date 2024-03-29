import pytest

from _2368 import BFSSolution, DFSSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([7, [[0, 1], [1, 2], [3, 1], [4, 0], [0, 5], [5, 6]], [4, 5]], 4),
            ([7, [[0, 1], [0, 2], [0, 5], [0, 4], [3, 2], [6, 5]], [4, 2, 1]], 3),
        ])
    def test(self, inputs, expected):
        for Solution in [DFSSolution(), BFSSolution()]:
            assert Solution.reachableNodes(*inputs) == expected
