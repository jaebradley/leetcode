import pytest

from _1399 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "maximum_inclusive_integer, expected",
        [
            (13, 4),
            (2, 2),
            (123, 1),
            (1000, 2),
            (10000, 1),
            (23, 4),
            (100, 1),
            (200, 2),
        ])
    def test(self, maximum_inclusive_integer, expected):
        assert Solution().countLargestGroup(maximum_inclusive_integer) == expected
