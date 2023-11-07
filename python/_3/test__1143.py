import pytest

from _1143 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            (["abccde", "ace"], 3),
            (["abc", "abc"], 3),
            (["abc", "def"], 0),
        ])
    def test(self, arguments, expected):
        assert Solution().longestCommonSubsequence(*arguments) == expected
