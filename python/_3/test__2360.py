import pytest

from _2360 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([3, 3, 4, 2, 3], 3),
            ([2, -1, 3, 1], -1)
        ])
    def test(self, input, expected):
        assert Solution().longestCycle(input) == expected
