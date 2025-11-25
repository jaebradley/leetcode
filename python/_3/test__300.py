import pytest

from _300 import LinearSearchSolution, BinarySearchSolution


class TestSolution:
    @pytest.mark.parametrize(
        "nums, expected",
        [
            ([10, 9, 2, 5, 3, 7, 101, 18], 4),
            ([0, 1, 0, 3, 2, 3], 4),
            ([7, 7, 7, 7, 7, 7, 7], 1),
            ([4,10,4,3,8,9], 3)
        ])
    def test(self, nums, expected):
        for solution in (LinearSearchSolution(), BinarySearchSolution()):
            assert solution.lengthOfLIS(nums) == expected
