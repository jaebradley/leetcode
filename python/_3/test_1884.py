import pytest

from _1884 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (100, 14),
            (2, 2),
        ])
    def test(self, input, expected):
        assert expected == Solution().twoEggDrop(input)
