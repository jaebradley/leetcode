import pytest

from _130 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "board, expected",
        [
            ([["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]],
             [["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "O", "X", "X"]]),
            ([["O", "O", "O", "O"], ["O", "O", "O", "O"], ["O", "O", "O", "O"], ["O", "O", "O", "O"]],
             [["O", "O", "O", "O"], ["O", "O", "O", "O"], ["O", "O", "O", "O"], ["O", "O", "O", "O"]]),
            ([["X"]], [["X"]]),
            ([["X", "O", "X"], ["O", "X", "O"], ["X", "O", "X"]], [["X", "O", "X"], ["O", "X", "O"], ["X", "O", "X"]])
        ])
    def test(self, board, expected):
        Solution().solve(board)
        assert board == expected
