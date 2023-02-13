import pytest

from _2374 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([1, 0, 0, 0, 0, 7, 7, 5], 7),
            ([2, 0, 0, 2], 0),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().edgeScore(inputs)
