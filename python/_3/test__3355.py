import pytest

from _3355 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1,0,1], [[0,2]]], True),
            ([[4,3,2,1], [[1,3],[0,2]]], False),
            ([[4, 3, 2, 1], [[0, 1], [0, 1], [0, 1], [0, 1]]], False),
            ([[4, 3, 0, 0], [[0, 1], [0, 1], [0, 1], [0, 1]]], True),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().isZeroArray(*inputs)
