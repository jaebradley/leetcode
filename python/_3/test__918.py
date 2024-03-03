import pytest

from _918 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([1, -2, 3, -2], 3),
            ([5, -3, 5], 10),
            ([-3, -2, -3], -2),
        ])
    def test(self, values, expected):
        assert Solution().maxSubarraySumCircular(values) == expected
