import pytest

from _2316 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([3, [[0, 1], [0, 2], [1, 2]]], 0),
            ([7, [[0, 2], [0, 5], [2, 4], [1, 6], [5, 4]]], 14),
            ([5, [[1, 0], [3, 1], [0, 4], [2, 1]]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().countPairs(*inputs) == expected
