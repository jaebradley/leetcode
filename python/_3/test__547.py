import pytest

from _547 import DfsSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[1, 1, 0], [1, 1, 0], [0, 0, 1]]], 2),
            ([[[1, 0, 0], [0, 1, 0], [0, 0, 1]]], 3)
        ])
    def test(self, inputs, expected):
        assert DfsSolution().findCircleNum(*inputs) == expected
