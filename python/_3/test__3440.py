import pytest

from _3440 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([5, [1, 3], [2, 5]], 2),
            ([10, [0, 7, 9], [1, 8, 10]], 7),
            ([10, [0, 8, 9], [1, 9, 10]], 7),
            ([10, [0, 3, 7, 9], [1, 4, 8, 10]], 6),
            ([5, [0, 1, 2, 3, 4], [1, 2, 3, 4, 5]], 0),
        ])
    def test(self, inputs, expected):
        assert Solution().maxFreeTime(*inputs) == expected
