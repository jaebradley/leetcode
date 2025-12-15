import pytest

from _50 import RecursiveSolution, IterativeSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((2, 10), 1024),
            ((2, 3), 8),
            ((2, -2), 0.25),
            ((2, -4), 0.0625),
            ((2.00, -200000000), 0)
        ])
    def test(self, inputs, expected):
        for solution in (RecursiveSolution(), IterativeSolution()):
            assert solution.myPow(*inputs) == expected
