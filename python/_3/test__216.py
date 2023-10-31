import pytest

from _216 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([3, 7], [[1, 2, 4]]),
            ([3, 9], [[1, 2, 6], [1, 3, 5], [2, 3, 4]]),
            ([4, 1], []),
        ])
    def test(self, arguments, expected):
        assert Solution().combinationSum3(*arguments) == expected
