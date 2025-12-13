import pytest

from _1701 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "customers, expected",
        [
            ([[1, 2], [2, 5], [4, 3]], 5.0),
            ([[5, 2], [5, 4], [10, 3], [20, 1]], 3.25),
        ])
    def test(self, customers, expected):
        assert Solution().averageWaitingTime(customers) == expected
