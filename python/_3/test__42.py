import pytest

from _42 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]], 6),
            ([[4, 2, 0, 3, 2, 5]], 9),
        ])
    def test(self, arguments, expected):
        assert Solution().trap(*arguments) == expected
