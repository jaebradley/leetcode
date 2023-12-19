import pytest

from _1091 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "grid, expected",
        [
            ([[0, 1], [1, 0]], 2),
            ([[0, 0, 0], [1, 1, 0], [1, 1, 0]], 4),
            ([[1, 0, 0], [1, 1, 0], [1, 1, 0]], -1),
        ])
    def test(self, grid, expected):
        assert Solution().shortestPathBinaryMatrix(grid) == expected
