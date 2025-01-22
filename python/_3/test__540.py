import pytest

from _540 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([1, 1, 2, 3, 3, 4, 4, 8, 8], 2),
            ([3, 3, 7, 7, 10, 11, 11], 10),
            ([3, 3, 7, 7, 11, 11, 12], 12),
            ([1, 3, 3, 7, 7, 11, 11], 1),
            ([1, 1, 3, 7, 7, 11, 11], 3),
            ([1], 1),
            ([1, 3, 3], 1),
        ])
    def test(self, values, expected):
        assert Solution().singleNonDuplicate(values) == expected
