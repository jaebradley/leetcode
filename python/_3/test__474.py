import pytest

from _474 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([["10", "0001", "111001", "1", "0"], 5, 3], 4),
            ([["10", "0", "1"], 1, 1], 2)
        ])
    def test(self, inputs, expected):
        assert Solution().findMaxForm(*inputs) == expected
