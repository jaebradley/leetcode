import pytest

from _1318 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([2, 6, 5], 3),
            ([4, 2, 7], 1),
            ([1, 2, 3], 0),
        ])
    def test(self, arguments, expected):
        assert Solution().minFlips(*arguments) == expected
