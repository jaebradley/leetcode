import pytest

from _1295 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([12, 345, 2, 6, 7896], 2),
            ([1000], 1)
        ])
    def test(self, input, expected):
        assert Solution().findNumbers(input) == expected
