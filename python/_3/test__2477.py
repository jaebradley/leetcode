import pytest

from _2477 import DfsSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[0, 1], [0, 2], [0, 3]], 5], 3),
            ([[[3, 1], [3, 2], [1, 0], [0, 4], [0, 5], [4, 6]], 2], 7),
            ([[], 1], 0),
        ])
    def test(self, inputs, expected):
        assert expected == DfsSolution().minimumFuelCost(*inputs)
