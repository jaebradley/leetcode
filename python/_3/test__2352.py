import pytest

from _2352 import HashSolution, TrieSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            # ([[[3, 2, 1], [1, 7, 6], [2, 7, 7]]], 1),
            ([[[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]], 3),
        ])
    def test(self, inputs, expected):
        for solution in [HashSolution(), TrieSolution()]:
            assert solution.equalPairs(*inputs) == expected
