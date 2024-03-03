import pytest

from _297 import LevelOrderCodec, TreeNode, RecursivePreOrderCodec


class TestSolution:
    @pytest.mark.parametrize(
        "root, expected",
        [
            (None, ""),
            (TreeNode(val=1), "1,null,null"),
            (TreeNode(val=1, left=TreeNode(2)), "1,2,null,null,null"),
            (TreeNode(val=1, right=TreeNode(2)), "1,null,2,null,null"),
            (TreeNode(val=1, left=TreeNode(2), right=TreeNode(3)), "1,2,3,null,null,null,null"),
        ])
    def test_level_order(self, root, expected):
        codec = LevelOrderCodec()
        assert codec.serialize(root=root) == expected
        assert codec.deserialize(data=expected) == root

    @pytest.mark.parametrize(
        "root, expected",
        [
            (None, "null"),
            (TreeNode(val=1), "1,null,null"),
            (TreeNode(val=1, left=TreeNode(2)), "1,2,null,null,null"),
            (TreeNode(val=1, right=TreeNode(2)), "1,null,2,null,null"),
            (TreeNode(val=1, left=TreeNode(2), right=TreeNode(3)), "1,2,null,null,3,null,null"),
        ])
    def test_recursive_preorder(self, root, expected):
        codec = RecursivePreOrderCodec()
        assert codec.serialize(root=root) == expected
        assert codec.deserialize(data=expected) == root
