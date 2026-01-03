import pytest

from _3528 import UnionFindSolution, BFSSolution


class TestSolution:
    @pytest.mark.parametrize(
        "conversions, expected",
        [
            (
                    [[0, 1, 2], [1, 2, 3]],
                    [1, 2, 6]
            ),
            (
                    [[0, 1, 2], [0, 2, 3], [1, 3, 4], [1, 4, 5], [2, 5, 2], [4, 6, 3], [5, 7, 4]],
                    [1, 2, 3, 8, 10, 6, 30, 24]
            ),
        ])
    def test(self, conversions, expected):
        for solution in (UnionFindSolution(), BFSSolution()):
            assert solution.baseUnitConversions(conversions) == expected
