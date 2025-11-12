import pytest

from _647 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ("abc", 3),
            ("aaa", 6),
            ("a", 1),
            ("aa", 3),
            ("aba", 4),
        ])
    def test(self, input, expected):
        assert Solution().countSubstrings(input) == expected
