import pytest

from _65 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "stringified_number, expected",
        [
            ("0", True),
            ("e", False),
            (".", False),
            ("0089", True),
            ("-0.1", True),
            ("+3.14", True),
            ("4.", True),
            ("-.9", True),
            ("2e10", True),
            ("-90E3", True),
            ("3e+7", True),
            ("+6e-1", True),
            ("99e2.5", False),
            ("--6", False),
            ("-+3", False),
            (".1", True),
            ("-.E3", False),
            ("92e1740e91", False),
        ])
    def test(self, stringified_number, expected):
        assert Solution().isNumber(stringified_number) == expected
