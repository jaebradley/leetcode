import pytest

from _189 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([1, 2, 3, 4, 5, 6, 7], 3),
             [5, 6, 7, 1, 2, 3, 4]),
            (([-1, -100, 3, 99], 2),
             [3, 99, -1, -100])
        ])
    def test(self, inputs, expected):
        Solution().rotate(*inputs)
        assert expected == inputs[0]
