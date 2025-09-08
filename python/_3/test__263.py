import pytest

from _263 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        (
                (6, True),
                (0, False),
                (1, True),
                (8, True),
                (14, False),
        ))
    def test(self, values, expected):
        assert Solution().isUgly(values) == expected
