import pytest

from _1423 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1,2,3,4,5,6,1], 3], 12),
            ([[2,2,2], 2], 4),
            ([[9,7,7,9,7,7,9], 7], 55),
        ])
    def test(self, inputs, expected):
        assert Solution().maxScore(*inputs) == expected
