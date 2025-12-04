import pytest

from _678 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
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
        ])
    def test(self, inputs, expected):
        assert Solution().checkValidString(*inputs) == expected
