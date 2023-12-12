import pytest

from _167 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[2, 7, 11, 15], 9], [1, 2]),
            ([[2, 3, 4], 6], [1, 3]),
            ([[-1, 0], -1], [1, 2]),
        ])
    def test(self, arguments, expected):
        assert Solution().twoSum(*arguments) == expected
