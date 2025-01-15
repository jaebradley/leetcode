import pytest

from _6 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["PAYPALISHIRING", 3], "PAHNAPLSIIGYIR"),
            (["PAYPALISHIRING", 4], "PINALSIGYAHRPI"),
            (["A", 1], "A"),
            (["AB", 1], "AB"),
        ])
    def test(self, inputs, expected):
        assert Solution().convert(*inputs) == expected
