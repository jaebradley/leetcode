import pytest

from _605 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 0, 0, 0, 1], 1], True),
            ([[1, 0, 0, 0, 1], 2], False),
            ([[1, 0, 0, 0, 0, 1], 2], False),
        ])
    def test(self, inputs, expected):
        assert Solution().canPlaceFlowers(*inputs) == expected
