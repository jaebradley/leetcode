import pytest

from _1466 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([6, [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]], 3),
            ([5, [[1, 0], [1, 2], [3, 2], [3, 4]]], 2),
            ([3, [[1, 0], [2, 0]]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().minReorder(*inputs) == expected
