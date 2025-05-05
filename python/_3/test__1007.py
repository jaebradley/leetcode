import pytest

from _1007 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[2, 1, 2, 4, 2, 2], [5, 2, 6, 2, 3, 2]], 2),
            ([[3, 5, 1, 2, 3], [3, 6, 3, 3, 4]], -1)
        ])
    def test(self, inputs, expected):
        assert Solution().minDominoRotations(*inputs) == expected
