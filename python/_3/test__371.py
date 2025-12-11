import pytest

from _371 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            # ((1, 2), 3),
            # ((2, 3), 5),
            # ((-100, 200), 100),
            # ((100, -200), -100),
            ((-100, -200), -300),
        ])
    def test(self, inputs, expected):
        assert Solution().getSum(*inputs) == expected
