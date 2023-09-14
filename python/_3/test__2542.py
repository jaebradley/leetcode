import pytest

from _2542 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [[1, 3, 3, 2], [2, 1, 3, 4], 3],
                    12),
            (
                    [[4, 2, 3, 1, 1], [7, 5, 10, 9, 6], 1],
                    30),
            (
                    [[2, 1, 14, 12], [11, 7, 13, 6], 3],
                    168),
        ])
    def test(self, inputs, expected):
        assert Solution().maxScore(*inputs) == expected
