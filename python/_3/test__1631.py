import pytest

from _1631 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "heights, expected",
        [
            (
                    [[1, 2, 2], [3, 8, 2], [5, 3, 5]],
                    2
            ),
            (
                    [[1, 2, 3], [3, 8, 4], [5, 3, 5]],
                    1
            ),
            (
                    [[1, 2, 1, 1, 1], [1, 2, 1, 2, 1], [1, 2, 1, 2, 1], [1, 2, 1, 2, 1], [1, 1, 1, 2, 1]],
                    0
            ),
            (
                    [[1, 10, 6, 7, 9, 10, 4, 9]],
                    9
            ),
        ])
    def test(self, heights, expected):
        assert Solution().minimumEffortPath(heights) == expected
