import pytest

from _1679 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3, 4], 5], 2),
            ([[3, 1, 3, 4, 3], 6], 1),
            ([[2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2], 3], 4)
        ])
    def test(self, inputs, expected):
        assert Solution().maxOperations(*inputs) == expected
