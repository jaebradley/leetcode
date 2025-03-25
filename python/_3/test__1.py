import pytest

from _1 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[2, 7, 11, 15], 9], [0, 1]),
            ([[3, 2, 4], 6], [1, 2]),
            ([[3, 3], 6], [0, 1]),
        ])
    def test(self, inputs, expected):
        assert Solution().twoSum(*inputs) == expected
