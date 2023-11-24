import pytest

from _55 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[2, 3, 1, 1, 4]], True),
            ([[3, 2, 1, 0, 4]], False),
        ])
    def test(self, arguments, expected):
        assert Solution().canJump(*arguments) == expected
