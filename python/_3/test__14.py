import pytest

from _14 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            (["flower", "flow", "flight"], "fl"),
            (["dog", "racecar", "car"], ""),
        ])
    def test(self, arguments, expected):
        assert Solution().longestCommonPrefix(arguments) == expected
