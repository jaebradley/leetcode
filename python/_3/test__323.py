import pytest

from _323 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((5, [[0,1],[1,2],[3,4]]), 2),
            ((5, [[0,1],[1,2],[2,3],[3,4]]), 1),
        ])
    def test(self, inputs, expected):
        assert Solution().countComponents(*inputs) == expected
