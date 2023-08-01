import pytest

from _1493 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 1, 0, 1]], 3),
            ([[0, 1, 1, 1, 0, 1, 1, 0, 1]], 5),
            ([[1, 1, 1]], 2),
            ([[0, 0, 1]], 1),
            ([[0, 0, 0]], 0),
            ([[1, 1, 0, 0, 1, 0, 1, 0, 0, 1]], 2)
        ])
    def test(self, inputs, expected):
        assert Solution().longestSubarray(*inputs) == expected
