import pytest

from _3371 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([2, 3, 5, 10], 10),
            ([-2,-1,-3,-6,4], 3),
            ([1,1,1,1,1,5,5], 10),
        ])
    def test(self, values, expected):
        assert Solution().getLargestOutlier(values) == expected
