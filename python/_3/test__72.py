import pytest

from _72 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            (["horse", "ros"], 3),
            (["intention", "execution"], 5),
        ])
    def test(self, arguments, expected):
        assert Solution().minDistance(*arguments) == expected
