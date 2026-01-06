import pytest

from _505 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            [[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1], [0, 0, 0, 0, 0]],
                            [0, 4],
                            [4, 4]
                    ),
                    12
            ),
            (
                    (
                            [[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1], [0, 0, 0, 0, 0]],
                            [0, 4],
                            [3, 2]
                    ),
                    -1
            ),
            (
                    (
                            [[0, 0, 0, 0, 0], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0], [0, 1, 0, 0, 1], [0, 1, 0, 0, 0]],
                            [4, 3],
                            [0, 1]
                    ),
                    -1
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().shortestDistance(*inputs) == expected
