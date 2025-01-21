import pytest

from _3371 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([2, 4, 5, 6], 5),
            ([-2, -1, -3, -6, 4], 4),
            ([1, 1, 1, 1, 1, 5, 5], 5),
        ])
    def test(self, values, expected):
        assert Solution().getLargestOutlier(values) == expected
