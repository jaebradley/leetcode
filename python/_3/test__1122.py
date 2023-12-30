import pytest

from _1122 import HashBasedSolution, CountingSortSolution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19], [2, 1, 4, 3, 9, 6]], [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]),
            ([[28, 6, 22, 8, 44, 17], [22, 28, 8, 6]], [22, 28, 8, 6, 17, 44]),
        ])
    def test(self, arguments, expected):
        for solution in [HashBasedSolution(), CountingSortSolution()]:
            assert solution.relativeSortArray(*arguments) == expected
