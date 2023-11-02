import pytest

from _136 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([2, 2, 1], 1),
            ([4, 1, 2, 1, 2], 4),
            ([1], 1),
        ])
    def test(self, input, expected):
        assert Solution().singleNumber(input) == expected
