import pytest

from _20 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ("(", False),
            ("()", True),
            ("((", False),
            (")(", False),
            ("(){}[", False),
            ("({[)", False),
            ("({[])}", False),
            ("({[]})", True),
        ])
    def test(self, input, expected):
        assert Solution().isValid(input) == expected
