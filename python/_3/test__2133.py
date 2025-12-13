import pytest

from _2133 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "matrix, expected",
        [
            (
                    [[1, 2, 3], [3, 1, 2], [2, 3, 1]],
                    True,
            ),
            (
                    [[1, 1, 1], [1, 2, 3], [1, 2, 3]],
                    False,
            ),
        ])
    def test(self, matrix, expected):
        assert Solution().checkValid(matrix) == expected
