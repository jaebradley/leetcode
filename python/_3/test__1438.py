import pytest

from _1438 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[8, 2, 4, 7], 4], 2),
            ([[10, 1, 2, 4, 7, 2], 5], 4),
            ([[4, 2, 2, 2, 4, 4, 2, 2], 0], 3),
        ])
    def test(self, inputs, expected):
        assert Solution().longestSubarray(*inputs) == expected
