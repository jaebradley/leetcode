import pytest

from _846 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([1, 2, 3, 6, 2, 3, 4, 7, 8], 3), True),
            (([1, 2, 3, 4, 5, 6, 7, 8, 9], 3), True),
            (([1, 2, 3, 6, 2, 3, 4, 7, 9], 3), False),
            (([1, 2, 3, 4, 5], 4), False),
            (([1, 2, 3, 4, 5], 10), False),
            (([1, 2, 2, 3, 3, 3, 4, 4, 5], 4), False),
            (([1, 1, 2, 2, 3, 3], 3), True)
        ])
    def test(self, inputs, expected):
        assert Solution().isNStraightHand(*inputs) == expected
