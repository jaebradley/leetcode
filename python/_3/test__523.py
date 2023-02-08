import pytest

from _523 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[23, 2, 4, 6, 7], 6], True),
            ([[23, 2, 4, 6, 6], 7], True),
            ([[23, 2, 6, 4, 7], 6], True)
        ])
    def test(self, inputs, expected):
        assert Solution().checkSubarraySum(*inputs) == expected
