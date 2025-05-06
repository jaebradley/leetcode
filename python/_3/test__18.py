import pytest

from _18 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [
                        [1, 0, -1, 0, -2, 2],
                        0
                    ],
                    [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
            ),
            (
                    [
                        [2, 2, 2, 2, 2],
                        8
                    ],
                    [[2, 2, 2, 2]]
            ),
            (
                    [
                        [0, 0, 0],
                        0
                    ],
                    []
            ),
            (
                    [
                        [0, 0, 0, 0],
                        0
                    ],
                    [[0, 0, 0, 0]]
            ),
            (
                    [
                        [-3, -1, 0, 2, 4, 5],
                        0
                    ],
                    [[-3, -1, 0, 4]]
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().fourSum(*inputs) == expected
