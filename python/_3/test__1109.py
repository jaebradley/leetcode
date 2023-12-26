import pytest

from _1109 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[[1, 2, 10], [2, 3, 20], [2, 5, 25]], 5], [10, 55, 45, 25, 25]),
            ([[[1, 2, 10], [2, 2, 15]], 2], [10, 25]),
        ])
    def test(self, arguments, expected):
        assert Solution().corpFlightBookings(*arguments) == expected
