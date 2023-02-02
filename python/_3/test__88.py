import pytest

from _88 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3], [1, 2, 2, 3, 5, 6]),
            ([[0], 0, [1], 1], [1])
        ])
    def test(self, inputs, expected):
        Solution().merge(*inputs)
        assert inputs[0] == expected
