import pytest

from _733 import Solution


class TestSolution:

    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[1, 1, 1], [1, 1, 0], [1, 0, 1]], 1, 1, 2], [[2, 2, 2], [2, 2, 0], [2, 0, 1]]),
            ([[[0, 0, 0], [0, 0, 0]], 0, 0, 0], [[0, 0, 0], [0, 0, 0]]),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().floodFill(*inputs)
