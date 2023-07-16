import pytest

from _334 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([[1, 2, 3, 4, 5]], True),
            ([[5, 4, 3, 2, 1]], False),
            ([[1, 1, 1]], False),
            ([[1, 0, 2, -1, 3]], True),
            ([[2, 3, 1, 4]], True),
        ])
    def test(self, inputs, expected):
        assert Solution().increasingTriplet(*inputs) == expected
