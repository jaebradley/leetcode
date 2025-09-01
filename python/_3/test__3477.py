import pytest

from _3477 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([4, 2, 5], [3, 5, 4]), 1),
            (([3, 6, 1], [6, 4, 7]), 0),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().numOfUnplacedFruits(*inputs)
