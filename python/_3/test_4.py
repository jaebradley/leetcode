import pytest

from _4 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 3], [2]], 2.0),
            ([[1, 2], [3, 4]], 2.5),
            ([[0, 0], [0, 0]], 0),
            ([[23, 26, 31, 35], [3, 5, 7, 9, 11, 16]], 13.5),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().findMedianSortedArrays(*inputs)
