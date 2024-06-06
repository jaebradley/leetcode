import pytest

from _690 import Solution, Employee


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([[Employee(1, 5, [2, 3]), Employee(2, 3, []), Employee(3, 3, [])], 1], 11),
            ([[Employee(1, 2, [5]), Employee(5, -3, [])], 5], -3),
        ])
    def test(self, values, expected):
        assert Solution().getImportance(*values) == expected
