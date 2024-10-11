import pytest

from _509 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (0, 0),
            (3, 2),
            (4, 3),
        ])
    def test(self, input, expected):
        assert expected == Solution().fib(input)
