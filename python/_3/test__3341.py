import pytest

from _3341 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "values, expected",
        [
            ([[0, 4], [4, 4]], 6),
            ([[0, 0, 0], [0, 0, 0]], 3),
            ([[0, 1], [1, 2]], 3),
        ])
    def test(self, values, expected):
        assert Solution().minTimeToReach(values) == expected
