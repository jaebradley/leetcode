import pytest

from _67 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["0", "0"], "0"),
            (["0", "1"], "1"),
            (["1", "1"], "10"),
            (["11", "1"], "100"),
            (["11", "11"], "110"),
            (["1010", "1011"], "10101"),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().addBinary(*inputs)
