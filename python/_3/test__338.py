import pytest

from _338 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (2, [0, 1, 1]),
            (5, [0, 1, 1, 2, 1, 2]),
        ])
    def test(self, input, expected):
        assert Solution().countBits(input) == expected
