import pytest

from _215 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [[3, 2, 1, 5, 6, 4], 2],
                    5),
            (
                    [[3, 2, 3, 1, 2, 4, 5, 5, 6], 4],
                    4),
        ])
    def test(self, inputs, expected):
        assert Solution().findKthLargest(*inputs) == expected
