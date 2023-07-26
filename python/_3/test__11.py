import pytest

from _11 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 8, 6, 2, 5, 4, 8, 3, 7]], 49),
            ([[1, 1]], 1),
        ])
    def test(self, inputs, expected):
        assert Solution().maxArea(*inputs) == expected
