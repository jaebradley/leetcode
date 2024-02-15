import pytest

from _137 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([2, 2, 3, 2], 3),
            ([0, 1, 0, 1, 0, 1, 99], 99),
        ])
    def test(self, values, expected):
        assert Solution().singleNumber(values) == expected
