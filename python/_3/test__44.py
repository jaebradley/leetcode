import pytest

from _44 import RecursiveSolution, IterativeSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (("aa", "a"), False),
            (("aa", "*"), True),
            (("cb", "?a"), False),
            (("", "*"), True),
            (("", "?"), False),
            (("aa", "**"), True),
            (("aa", "a?"), True),
            (("aba", "???"), True),
            (("aba", "?*"), True),
            (("aba", "?***********"), True),
            (("", ""), True),
            (("aab", "c*a*b"), False),
        ])
    def test(self, inputs, expected):
        for solution in (RecursiveSolution(), IterativeSolution()):
            assert solution.isMatch(*inputs) == expected
