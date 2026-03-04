import pytest

from _1091 import BFSSolution, NonOverwritingBFS


class TestSolution:
    @pytest.mark.parametrize(
        "grid, expected",
        [
            ([[0, 1], [1, 0]], 2),
            ([[0, 0, 0], [1, 1, 0], [1, 1, 0]], 4),
            ([[1, 0, 0], [1, 1, 0], [1, 1, 0]], -1),
        ])
    def test(self, grid, expected):
        for solution in (NonOverwritingBFS(), BFSSolution()):
            assert solution.shortestPathBinaryMatrix(grid) == expected
