import pytest

from _45 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[2, 3, 1, 1, 4]], 2),
            ([[2, 3, 0, 1, 4]], 2),
        ])
    def test(self, arguments, expected):
        assert Solution().jump(*arguments) == expected
