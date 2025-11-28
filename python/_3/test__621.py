import pytest

from _621 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((["A","A","A","B","B","B"], 2), 8),
            ((["A","C","A","B","D","B"], 1), 6),
            ((["A","A","A", "B","B","B"], 3), 10),
        ]
    )
    def test(self, inputs, expected):
        assert Solution().leastInterval(*inputs) == expected
