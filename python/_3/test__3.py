import pytest

from _3 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "word, expected",
        [
            ("abcabcbb", 3),
            ("bbbbb", 1),
            ("pwwkew", 3),
        ])
    def test(self, word, expected):
        assert Solution().lengthOfLongestSubstring(word) == expected
