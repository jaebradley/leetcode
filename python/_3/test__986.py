import pytest

from _986 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 [[0, 2], [5, 10], [13, 23], [24, 25]],
                 [[1, 5], [8, 12], [15, 24], [25, 26]]
             ],
             [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]),
            ([
                 [[1, 3], [5, 9]],
                 []
             ], [])
        ])
    def test(self, inputs, expected):
        assert Solution().intervalIntersection(*inputs) == expected
