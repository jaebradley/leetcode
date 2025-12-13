import pytest

from _977 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "nums, expected",
        [
            (
                    [-4, -1, 0, 3, 10],
                    [0, 1, 9, 16, 100],
            ),
            (
                    [-7, -3, 2, 3, 11],
                    [4, 9, 9, 49, 121],
            ),
        ])
    def test(self, nums, expected):
        assert Solution().sortedSquares(nums) == expected
