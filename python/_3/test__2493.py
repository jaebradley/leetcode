import pytest

from _2493 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([6, [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]], 4),
            ([3, [[1,2],[2,3],[3,1]]], -1),
        ])
    def test(self, inputs, expected):
        assert Solution().magnificentSets(*inputs) == expected
