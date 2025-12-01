import pytest

from _7 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            (123, 321),
            (0, 0),
            (1, 1),
            (120, 21),
            (-120, -21),
            (-1, -1),
            (-10, -1),
            (101, 101),
            (-111, -111),
            (100, 1),
        ])
    def test(self, value, expected):
        assert Solution().reverse(value) == expected
