import pytest

from _134 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[1, 2, 3, 4, 5], [3, 4, 5, 1, 2]], 3),
            ([[2, 3, 4], [3, 4, 3]], -1),
            ([[5, 8, 2, 8], [6, 5, 6, 6]], 3),
        ])
    def test(self, arguments, expected):
        assert Solution().canCompleteCircuit(*arguments) == expected
