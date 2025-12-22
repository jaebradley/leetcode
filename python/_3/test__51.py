import pytest

from _51 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "n, expected",
        [
            (4, [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]),
            (1, [["Q"]]),
            (2, []),
        ])
    def test(self, n, expected):
        assert Solution().solveNQueens(n) == expected
