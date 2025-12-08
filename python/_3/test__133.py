import pytest

from _133 import Solution, Node


class TestSolution:
    @pytest.mark.parametrize(
        "node, expected",
        [
            (Node(1), Node(1)),
            (None, None),
            (Node(1, neighbors=[Node(2)]), Node(val=1, neighbors=[Node(2)]))
        ])
    def test(self, node, expected):
        assert Solution().cloneGraph(node) == expected