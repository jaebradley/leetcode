import pytest

from _76 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "words, expected",
        [
            (["ADOBECODEBANC", "ABC"], "BANC"),
            (["a", "a"], "a"),
            (["a", "aa"], ""),
            (["ab", "a"], "a"),
        ])
    def test(self, words, expected):
        assert Solution().minWindow(*words) == expected
