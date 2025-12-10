import pytest

from _704 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([-1,0,3,5,9,12], 9), 4),
            (([-1,0,3,5,9,12], 2), -1),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().search(*inputs)
