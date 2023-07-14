import pytest

from _1431 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[2, 3, 5, 1, 3], 3], [True, True, True, False, True]),
            ([[4, 2, 1, 1, 2], 1], [True, False, False, False, False]),
        ])
    def test(self, inputs, expected):
        assert Solution().kidsWithCandies(*inputs) == expected
