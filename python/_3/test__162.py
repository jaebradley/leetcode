import pytest

from _162 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "elements, expected",
        [
            (
                    [1],
                    0
            ),
            (
                    [1, 2, 1, 3, 5, 6, 4],
                    5
            ),
            (
                    [1, 2, 3, 4],
                    3
            ),
            (
                    [4, 3, 2, 1],
                    0
            ),
            (
                    [5, 4, 3, 4, 5],
                    0
            ),
        ])
    def test(self, elements, expected):
        assert Solution().findPeakElement(elements) == expected
