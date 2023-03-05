import pytest

from _1353 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[1, 2], [2, 3], [3, 4]]], 3),
            ([[[1, 2], [2, 3], [3, 4], [1, 2]]], 4),
            ([[[1, 4], [4, 4], [2, 2], [3, 4], [1, 1]]], 4)
        ])
    def test(self, inputs, expected):
        assert Solution().maxEvents(*inputs) == expected
