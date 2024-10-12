import pytest

from _841 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[[1], [2], [3], []]], True),
            ([[[1, 3], [3, 0, 1], [2], [0]]], False),
        ])
    def test(self, inputs, expected):
        assert Solution().canVisitAllRooms(*inputs) == expected
