import pytest

from _2405 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            ("abcdefg", 1),
            ("abacaba", 4),
            ("ssssss", 6),
        ])
    def test(self, value, expected):
        assert Solution().partitionString(value) == expected
