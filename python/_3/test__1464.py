import pytest

from _1464 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([3, 4, 5, 2], 12),
            ([1, 5, 4, 5], 16),
            ([3, 7], 12)
        ])
    def test(self, inputs, expected):
        assert expected == Solution().maxProduct(inputs)
