import pytest

from _286 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "rooms, expected",
        [
            ([[2147483647, -1, 0, 2147483647], [2147483647, 2147483647, 2147483647, -1],
              [2147483647, -1, 2147483647, -1], [0, -1, 2147483647, 2147483647]],
             [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]),
            ([[-1]], [[-1]]),
        ]
    )
    def test(self, rooms, expected):
        Solution().wallsAndGates(rooms)
        assert rooms == expected
