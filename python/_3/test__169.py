import pytest

from _169 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[3, 2, 3]], 3),
            ([[2, 2, 1, 1, 1, 2, 2]], 2),
        ])
    def test(self, arguments, expected):
        assert Solution().majorityElement(*arguments) == expected
