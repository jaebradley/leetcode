import pytest

from _449 import LevelOrderCodec, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "root, expected",
        (
                TreeNode(
                    2,
                    TreeNode(3),
                    TreeNode(1)
                ),
            "2|3,1"
        ),
        (
                None,
                ""
        ),
        (
                TreeNode(1),
                "1"
        ),
        (
                TreeNode(1, TreeNode(2)),
                "1|2,*"
        ),
        (
                TreeNode(2, right=TreeNode(2)),
                "1|*,2"
        )
    )
    def test(self, root, expected):
        assert LevelOrderCodec().serialize(root) == expected
        assert LevelOrderCodec().deserialize(expected) == root
