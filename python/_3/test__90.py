import pytest

from _90 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            (
                    [1, 2, 2],
                    [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]],
            ),
            (
                    [0],
                    [[], [0]],
            ),
        ])
    def test(self, value, expected):
        assert sorted(Solution().subsetsWithDup(value)) == sorted(expected)
