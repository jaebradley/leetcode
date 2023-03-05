import pytest

from _2421 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 1, 2, 2, 3], [[0, 1], [1, 2], [2, 3], [2, 4]]], 7),
            ([[1], []], 1),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().numberOfGoodPaths(*inputs)
