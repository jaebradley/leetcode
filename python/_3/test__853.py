import pytest

from _853 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]), 3),
            ((10, [3], [3]), 1),
            ((100, [0, 2, 4], [4, 2, 1]), 1),
            ((100, [1, 50, 99], [1, 1, 1]), 3),
        ])
    def test(self, inputs, expected):
        assert Solution().carFleet(*inputs) == expected
