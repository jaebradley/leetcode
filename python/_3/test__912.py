import pytest

from _912 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        (
                ([5, 2, 3, 1], [1, 2, 3, 5]),
                ([5, 1, 1, 2, 0, 0], [0, 0, 1, 1, 2, 5]),
        ))
    def test(self, values, expected):
        assert Solution().sortArray(values) == expected
