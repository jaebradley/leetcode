import pytest

from _658 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3, 4, 5], 4, 3], [1, 2, 3, 4]),
            ([[1, 2, 3, 4, 5], 4, -1], [1, 2, 3, 4]),
        ])
    def test(self, inputs, expected):
        assert Solution().findClosestElements(*inputs) == expected
