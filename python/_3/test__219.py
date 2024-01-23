import pytest

from _219 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([[1, 2, 3, 1], 3], True),
            ([[1, 0, 1, 1], 1], True),
            ([[1, 2, 3, 1, 2, 3], 2], False),
        ])
    def test(self, arguments, expected):
        assert Solution().containsNearbyDuplicate(*arguments) == expected
