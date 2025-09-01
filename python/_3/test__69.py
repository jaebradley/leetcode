import pytest

from _69 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (0, 0),
            (1, 1),
            (2, 1),
            (3, 1),
            (4, 2),
            (5, 2),
            (6, 2),
        ])
    def test(self, inputs, expected):
        assert Solution().mySqrt(inputs) == expected