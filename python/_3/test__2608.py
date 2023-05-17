import pytest

from _2608 import DfsSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([7, [[0, 1], [1, 2], [2, 0], [3, 4], [4, 5], [5, 6], [6, 3]]], 3),
            ([4, [[0, 1], [0, 2]]], -1),
            (
                    [20,
                     [[8, 19], [1, 19], [0, 19], [7, 15], [13, 17], [4, 19], [2, 6], [17, 18], [7, 14], [7, 18], [5, 6],
                      [16, 17], [1, 12], [9, 16], [6, 15], [2, 14], [4, 17], [2, 10], [0, 18], [7, 11], [5, 14],
                      [8, 14], [4, 9], [7, 9], [9, 18], [0, 14]]],
                    3
            ),
        ])
    def test(self, inputs, expected):
        assert DfsSolution().findShortestCycle(*inputs) == expected
