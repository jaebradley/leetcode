import pytest

from _66 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "digits, expected",
        [
            ([1, 2, 3], [1, 2, 4]),
            ([9], [1, 0]),
            ([1, 0, 0], [1, 0, 1]),
            ([1], [2]),
            ([8, 9, 9, 9], [9, 0, 0, 0]),
        ])
    def test(self, digits, expected):
        assert Solution().plusOne(digits) == expected
