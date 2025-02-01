import pytest

from _32 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            ("(()", 2),
            (")()())", 4),
            ("", 0),
            (")", 0),
            ("(", 0),
            ("))((", 0),
            ("))()()", 4),
            ("(((((())))))", 12),
            ("((((((", 0),
            ("(((((()", 2),
            ("(((((())(())))))", 16),
            ("()(()", 2),
            ("(()))())(", 4),
            ("(()(((()", 2)
        ])
    def test(self, value, expected):
        assert Solution().longestValidParentheses(value) == expected
