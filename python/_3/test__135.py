import pytest

from _135 import TwoPassSolution, OnePassSolution


class TestSolution:
    @pytest.mark.parametrize(
        "ratings, expected",
        [
            ([1, 0, 2], 5),
            ([1, 2, 2], 4),
        ])
    def test(self, ratings, expected):
        for solution in [TwoPassSolution(), OnePassSolution()]:
            assert solution.candy(ratings) == expected
