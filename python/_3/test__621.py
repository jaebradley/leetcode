import pytest

from _621 import MathematicalSolution, PriorityQueueSolution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((["A", "A", "A", "B", "B", "B"], 2), 8),
            ((["A", "C", "A", "B", "D", "B"], 1), 6),
            ((["A", "A", "A", "B", "B", "B"], 3), 10),
            ((["B", "C", "D", "A", "A", "A", "A", "G"], 1), 8),
        ]
    )
    def test(self, inputs, expected):
        for solution in (MathematicalSolution(), PriorityQueueSolution()):
            assert solution.leastInterval(*inputs) == expected
