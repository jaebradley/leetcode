import pytest

from _1514 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (3, [[0, 1], [1, 2], [0, 2]], [0.5, 0.5, 0.2], 0, 2),
                    0.25
            ),
            (
                    (3, [[0, 1], [1, 2], [0, 2]], [0.5, 0.5, 0.3], 0, 2),
                    0.3
            ),
            (
                    (3, [[0, 1]], [0.5], 0, 2),
                    0
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().maxProbability(*inputs) == expected
