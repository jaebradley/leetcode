import pytest

from _373 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([[1, 7, 11], [2, 4, 6], 3], [[1, 2], [1, 4], [1, 6]]),
            ([[1, 1, 2], [1, 2, 3], 2], [[1, 1], [1, 1]]),
            ([[1, 1, 1], [1, 1, 1], 2], [[1, 1], [1, 1]]),
            ([[1, 1, 1], [1, 1, 1], 3], [[1, 1], [1, 1], [1, 1]]),
            ([[1, 2, 4, 5, 6], [3, 5, 7, 9], 3], [[1, 3], [2, 3], [1, 5]]),
        ])
    def test(self, values, expected):
        assert Solution().kSmallestPairs(*values) == expected
