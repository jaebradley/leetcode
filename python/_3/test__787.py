import pytest

from _787 import BFSSolution, BellmanFordSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            4,
                            [[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200]],
                            0,
                            3,
                            1
                    ),
                    700
            ),
            (
                    (
                            3,
                            [[0, 1, 100], [1, 2, 100], [0, 2, 500]],
                            0,
                            2,
                            1
                    ),
                    200
            ),
            (
                    (
                            3,
                            [[0, 1, 100], [1, 2, 100], [0, 2, 500]],
                            0,
                            2,
                            0
                    ),
                    500
            ),
            (
                    (
                            11,
                            [[0, 3, 3], [3, 4, 3], [4, 1, 3], [0, 5, 1], [5, 1, 100], [0, 6, 2], [6, 1, 100], [0, 7, 1],
                             [7, 8, 1], [8, 9, 1], [9, 1, 1], [1, 10, 1], [10, 2, 1], [1, 2, 100]],
                            0,
                            2,
                            4
                    ),
                    11
            ),
        ])
    def test(self, inputs, expected):
        for solution in (BellmanFordSolution(), BFSSolution()):
            assert solution.findCheapestPrice(*inputs) == expected
