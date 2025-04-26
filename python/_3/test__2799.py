import pytest

from _2799 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ([5, 5, 5, 5], 10),
            ([1], 1),
            ([], 0),
            ([1, 2], 1),
            ([1, 2, 2, 1], 5),
            ([1,3,1,2,2], 4)
        ])
    def test(self, input, expected):
        assert Solution().countCompleteSubarrays(input) == expected
