import pytest

from _62 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([3, 7], 28),
            ([3, 2], 3),
        ])
    def test(self, arguments, expected):
        assert Solution().uniquePaths(*arguments) == expected
