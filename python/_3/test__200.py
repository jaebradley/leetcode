import pytest

from _200 import DfsSolution, UnionFindSolution, BfsSolution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([], 0),
            ([["1"]], 1),
            ([["1", "0"]], 1),
            ([["1"], ["1"]], 1),
            ([
                 ["1", "0", "1", "1", "1"],
                 ["1", "0", "1", "0", "1"],
                 ["1", "1", "1", "0", "1"]
             ],
             1),
            ([["1", "0"], ["0", "1"]], 2),
            ([
                 ["1", "1", "1", "1", "0"],
                 ["1", "1", "0", "1", "0"],
                 ["1", "1", "0", "0", "0"],
                 ["0", "0", "0", "0", "0"]
             ],
             1),
            ([
                 ["1", "1", "0", "0", "0"],
                 ["1", "1", "0", "0", "0"],
                 ["0", "0", "1", "0", "0"],
                 ["0", "0", "0", "1", "1"]
             ],
             3)
        ])
    def test(self, input, expected):
        for solution in [
            DfsSolution(),
            UnionFindSolution(),
            BfsSolution()
        ]:
            assert solution.numIslands(input) == expected
