import pytest

from _96 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "node_count, expected",
        [
            (1, 1),
            (2, 2),
            (3, 5),
            (4, 14),
            (5, 42),
            (6, 132),
        ])
    def test_level_order(self, node_count, expected):
        assert Solution().numTrees(node_count) == expected
