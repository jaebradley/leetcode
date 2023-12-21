import pytest

from _1094 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[[2, 1, 5], [3, 3, 7]], 4], False),
            ([[[2, 1, 5], [3, 3, 7]], 5], True),
        ])
    def test(self, arguments, expected):
        assert Solution().carPooling(*arguments) == expected
