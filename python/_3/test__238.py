import pytest

from _238 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "numbers, expected",
        [
            ([1, 2, 3, 4], [24, 12, 8, 6]),
            ([-1, 1, 0, -3, 3], [0, 0, 9, 0, 0]),
        ])
    def test(self, numbers, expected):
        assert Solution().productExceptSelf(numbers) == expected
