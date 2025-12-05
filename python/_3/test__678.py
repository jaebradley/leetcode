import pytest

from _678 import DPSolution, TwoPointerGreedySolution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            ("()", True),
            ("(*)", True),
            ("(*))", True),
            ("****", True),
            ("(*)*", True),
            ("(", False),
            ("((", False),
            ("((*", False),
            ("(*", True),
            (")*", False),
            (")(", False),
            ("*()", True),
            ("*()*", True),
            ("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()", True),
        ])
    def test(self, value, expected):
        for solution in (DPSolution(), TwoPointerGreedySolution()):
            assert solution.checkValidString(value) == expected
