import pytest

from _322 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        (
            (([1, 2, 5], 11), 3),
            (([2], 3), -1),
            (([1], 0), 0),
            (([5], 5), 1),
            (([3, 4, 5], 25), 5),
        ))
    def test(self, inputs, expected):
        assert Solution().coinChange(*inputs) == expected
