import pytest

from _5 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ("babad", "bab"),
            ("cbbd", "bb"),
            ("babab", "babab"),
        ])
    def test(self, input, expected):
        assert Solution().longestPalindrome(input) == expected
