import pytest

from _1137 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([4], 4),
            ([25], 1389537),
        ])
    def test(self, inputs, expected):
        assert Solution().tribonacci(*inputs) == expected
