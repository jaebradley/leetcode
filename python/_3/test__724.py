import pytest

from _724 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 7, 3, 6, 5, 6]], 3),
            ([[1, 2, 3]], -1),
            ([[2, 1, -1]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().pivotIndex(*inputs) == expected
