import pytest

from _115 import RecursiveSolution, IterativeSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (("abd", "zyx"), 0),
            (("abd", "abc"), 0),
            (("rabbbit", "rabbit"), 3),
            (("babgbag", "bag"), 5),
        ])
    def test(self, inputs, expected):
        for solution in (RecursiveSolution(), IterativeSolution()):
            assert expected == solution.numDistinct(*inputs)
