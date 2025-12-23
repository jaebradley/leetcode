import pytest

from _3043 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([1, 10, 100], [1000]), 3),
            (([1, 10, 100], [100]), 3),
            (([1, 2, 3], [4, 4, 4]), 0),
            (([41, 43, 22, 36, 28], [36, 33, 19, 20, 20]), 2),
        ])
    def test(self, inputs, expected):
        assert Solution().longestCommonPrefix(*inputs) == expected
