import pytest

from _1732 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[-5, 1, 5, 0, -7]], 1),
            ([[-4, -3, -2, -1, 4, 3, 2]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().largestAltitude(*inputs) == expected
