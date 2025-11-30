import pytest

from _1046 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "nums, expected",
        [
            ([2, 7, 4, 1, 8, 1], 1),
            ([1], 1),
        ])
    def test(self, nums, expected):
        assert Solution().lastStoneWeight(nums) == expected
