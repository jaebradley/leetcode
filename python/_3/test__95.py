import pytest

from _95 import TreeNode, Solution


class TestSolution:
    @pytest.mark.parametrize(
        "node_count, expected",
        [
            (1, [TreeNode(val=1)]),
            (2, [TreeNode(val=1, right=TreeNode(val=2)), TreeNode(val=2, left=TreeNode(val=1))]),
            (3,
             [
                 TreeNode(val=1, right=TreeNode(val=2, right=TreeNode(val=3))),
                 TreeNode(val=1, right=TreeNode(val=3, left=TreeNode(val=2))),
                 TreeNode(val=2, left=TreeNode(val=1), right=TreeNode(val=3)),
                 TreeNode(val=3, left=TreeNode(val=1, right=TreeNode(val=2))),
                 TreeNode(val=3, left=TreeNode(val=2, left=TreeNode(val=1))),
             ])
        ])
    def test_level_order(self, node_count, expected):
        assert Solution().generateTrees(node_count) == expected
