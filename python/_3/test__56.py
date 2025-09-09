import pytest

from _56 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        (
                ([[1, 3], [2, 6], [8, 10], [15, 18]], [[1, 6], [8, 10], [15, 18]]),
                ([[1, 4], [4, 5]], [[1, 5]]),
                ([[4, 7], [1, 4]], [[1, 7]]),
                ([[1, 1]], [[1, 1]]),
        ))
    def test(self, value, expected):
        assert Solution().merge(value) == expected
