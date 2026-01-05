import pytest

from _1059 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [3, [[0, 1], [0, 2]], 0, 2],
                    False
            ),
            (
                    [4, [[0, 1], [0, 3], [1, 2], [2, 1]], 0, 3],
                    False
            ),
            (
                    [4, [[0, 1], [0, 2], [1, 3], [2, 3]], 0, 3],
                    True
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().leadsToDestination(*inputs) == expected
