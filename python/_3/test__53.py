import pytest

from _53 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([-2,1,-3,4,-1,2,1,-5,4], 6),
            ([1], 1),
            ([5,4,-1,7,8], 23),
        ])
    def test(self, values, expected):
        assert Solution().maxSubArray(values) == expected
