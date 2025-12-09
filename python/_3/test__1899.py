import pytest

from _1899 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([[2, 5, 3], [1, 8, 4], [1, 7, 5]], [2, 7, 5]), True),
            (([[3, 4, 5], [4, 5, 6]], [3, 2, 5]), False),
            (([[2, 5, 3], [2, 3, 4], [1, 2, 5], [5, 2, 3]], [5, 5, 5]), True),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().mergeTriplets(*inputs)
