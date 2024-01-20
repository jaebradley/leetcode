import pytest

from _228 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "nums, ranges",
        [
            ([0, 1, 2, 4, 5, 7], ["0->2", "4->5", "7"]),
            ([0, 2, 3, 4, 6, 8, 9], ["0", "2->4", "6", "8->9"]),
        ])
    def test(self, nums, ranges):
        assert Solution().summaryRanges(nums) == ranges
