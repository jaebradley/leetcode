import pytest

from _1579 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([4, [[3, 1, 2], [3, 2, 3], [1, 1, 3], [1, 2, 4], [1, 1, 2], [2, 3, 4]]], 2),
            ([4, [[3, 1, 2], [3, 2, 3], [1, 1, 4], [2, 1, 4]]], 0),
            ([4, [[3, 2, 3], [1, 1, 2], [2, 3, 4]]], -1),
        ])
    def test(self, inputs, expected):
        assert Solution().maxNumEdgesToRemove(*inputs) == expected
