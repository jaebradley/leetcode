import pytest

from _1207 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 2, 1, 1, 3]], True),
            ([[1, 2]], False),
            ([[-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]], True),
        ])
    def test(self, inputs, expected):
        assert Solution().uniqueOccurrences(*inputs) == expected
