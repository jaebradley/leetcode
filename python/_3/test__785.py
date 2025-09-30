import pytest

from _785 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]], False),
            ([[1, 3], [0, 2], [1, 3], [0, 2]], True),
        ])
    def test(self, input, expected):
        assert expected == Solution().isBipartite(input)
