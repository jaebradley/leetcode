import pytest

from _994 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[2, 1, 1], [1, 1, 0], [0, 1, 1]]], 4),
            ([[[2, 1, 1], [0, 1, 1], [1, 0, 1]]], -1),
            ([[[0, 2]]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().orangesRotting(*inputs) == expected
