import pytest

from _3439 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([5, 1, [1, 3], [2, 5]], 2),
            ([10, 1, [0, 2, 9], [1, 4, 10]], 6),
            ([5, 2, [0, 1, 2, 3, 4], [1, 2, 3, 4, 5]], 0),
            ([5, 2, [0, 1, 3, 4], [1, 2, 4, 5]], 1),
            ([5, 1, [0, 1, 3, 4], [1, 2, 4, 5]], 1),
            ([100, 2, [0, 1, 50, 75], [1, 2, 73, 100]], 50),
            ([34, 2, [0, 17], [14, 19]], 18),
            ([21, 1, [7, 10, 16], [10, 14, 18]], 7),
        ])
    def test(self, inputs, expected):
        assert Solution().maxFreeTime(*inputs) == expected
