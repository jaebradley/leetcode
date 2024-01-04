import pytest

from _1124 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[9, 9, 6, 0, 6, 6, 9]], 3),
            ([[6, 6, 6]], 0),
            ([[6, 9, 9]], 3),
            ([[6, 6, 9]], 1),
            ([[9]], 1),
            ([[8]], 0),
        ])
    def test(self, arguments, expected):
        assert Solution().longestWPI(*arguments) == expected
