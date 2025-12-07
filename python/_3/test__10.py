import pytest

from _10 import TopDownSolution, BottomUpSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (("aa", "a"), False),
            (("aa", "a*"), True),
            (("ab", ".*"), True),
            (("ab", ".."), True),
            (("aaa", "..a"), True),
            (("aaa", "a.."), True),
            (("aaa", "a*"), True),
            (("aba", "a*"), False),
            (("aba", ".*.*"), True),
            (("aaaaaa", "a.*aaaa"), True),
            (("abaaaa", ".*ca"), False),
        ])
    def test(self, inputs, expected):
        for solution in (TopDownSolution(), BottomUpSolution()):
            assert solution.isMatch(*inputs) == expected