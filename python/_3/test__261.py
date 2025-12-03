import pytest

from _261 import DFSSolution, BFSSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((5, [[0, 1], [0, 2], [0, 3], [1, 4]]), True),
            ((5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]), False),
            ((4, [[2, 3], [1, 2], [1, 3]]), False),
        ])
    def test(self, inputs, expected):
        for solution in (DFSSolution(), BFSSolution()):
            assert solution.validTree(*inputs) == expected
