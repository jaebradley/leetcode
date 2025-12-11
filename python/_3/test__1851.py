import pytest

from _1851 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([[1, 4], [2, 4], [3, 6], [4, 4]], [2, 3, 4, 5]), [3, 3, 1, 4]),
            (([[2, 3], [2, 5], [1, 8], [20, 25]], [2, 19, 5, 22]), [2, -1, 4, 6]),
        ])
    def test(self, inputs, expected):
        assert Solution().minInterval(*inputs) == expected
