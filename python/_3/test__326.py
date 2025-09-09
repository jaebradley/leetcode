import pytest

from _326 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        (
                (27, True),
                (0, False),
                (-1, False),
                (1, True),
                (2, False),
                (3, True),
                (8, False),
                (9, True),
        ))
    def test(self, value, expected):
        assert Solution().isPowerOfThree(value) == expected
