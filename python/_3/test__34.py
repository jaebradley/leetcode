import pytest

from _34 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([5, 7, 7, 8, 8, 10], 8), [3, 4]),
            (([5, 7, 7, 8, 8, 10], 6), [-1, -1]),
            (([], 0), [-1, -1]),
            (([1, 1, 1, 1], 1), [0, 3]),
        ])
    def test(self, inputs, expected):
        assert Solution().searchRange(*inputs) == expected
