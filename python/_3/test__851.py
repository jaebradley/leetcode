import pytest

from _851 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            (
                    [
                        [[1, 0], [2, 1], [3, 1], [3, 7], [4, 3], [5, 3], [6, 3]],
                        [3, 2, 5, 4, 6, 1, 7, 0]
                    ],
                    [5, 5, 2, 5, 4, 5, 6, 7]),
            (
                    [
                        [],
                        [0]
                    ],
                    [0]),
        ])
    def test(self, arguments, expected):
        assert Solution().loudAndRich(*arguments) == expected
