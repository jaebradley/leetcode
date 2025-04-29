import pytest

from _2962 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[5, 5, 5, 5], 2], 6),
            ([[1, 4, 2, 1], 3], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().countSubarrays(*inputs) == expected
