import pytest

from _287 import BinarySearchSolution, LinkedListCycleSolution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([1, 3, 4, 2, 2], 2),
            ([3, 1, 3, 4, 2], 3),
            ([3, 3, 3, 3, 3], 3),
        ])
    def test(self, values, expected):
        for solution in [BinarySearchSolution(), LinkedListCycleSolution()]:
            assert solution.findDuplicate(values) == expected
