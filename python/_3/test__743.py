import pytest

from _743 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    ([[2, 1, 1], [2, 3, 1], [3, 4, 1]], 4, 2),
                    2
            ),
            (
                    ([[1, 2, 1]], 2, 1),
                    1
            ),
            (
                    ([[1, 2, 1]], 2, 2),
                    -1
            ),
            (
                    ([[1, 2, 1], [2, 1, 1]], 2, 1),
                    1
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().networkDelayTime(*inputs) == expected
