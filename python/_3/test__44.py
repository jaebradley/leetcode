import pytest

from _44 import RecursiveSolution


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
        ])
    def test(self, inputs, expected):
        assert RecursiveSolution().isMatch(*inputs) == expected
