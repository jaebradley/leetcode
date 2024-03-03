import pytest

from _297 import LevelOrderCodec, TreeNode


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
    def test(self, root, expected):
        codec = LevelOrderCodec()
        assert codec.serialize(root=root) == expected
        assert codec.deserialize(data=expected) == root
