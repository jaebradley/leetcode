import pytest

from _153 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([3, 4, 5, 1, 2], 1),
            ([4, 5, 6, 7, 0, 1, 2], 0),
            ([11, 13, 15, 17], 11),
        ])
    def test(self, input, expected):
        assert Solution().findMin(input) == expected
