import pytest

from _1944 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([10, 6, 8, 5, 11, 9], [3, 1, 2, 1, 1, 0]),
            ([5, 1, 2, 3, 10], [4, 1, 1, 1, 0]),
        ])
    def test(self, inputs, expected):
        assert Solution().canSeePersonsCount(inputs) == expected
