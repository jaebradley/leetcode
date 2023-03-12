import pytest

from _329 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[9, 9, 4], [6, 6, 8], [2, 1, 1]], 4),
            ([[3, 4, 5], [3, 2, 6], [2, 2, 1]], 4),
            ([[1]], 1),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().longestIncreasingPath(inputs)
