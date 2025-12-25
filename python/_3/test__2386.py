import pytest

from _2386 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([2, 4, -2], 5), 2),
            (([1, -2, 3, 4, -10, 12], 16), 10),
        ])
    def test(self, inputs, expected):
        assert Solution().kSum(*inputs) == expected
