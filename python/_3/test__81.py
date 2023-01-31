import pytest

from _81 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[2, 5, 6, 0, 0, 1, 2], 0], True),
            ([[1, 0, 1, 1, 1], 0], True),
            ([[1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 13], True),
            ([[2, 5, 6, 0, 0, 1, 2], 3], False)
        ])
    def test(self, inputs, expected):
        assert expected == Solution().search(*inputs)
