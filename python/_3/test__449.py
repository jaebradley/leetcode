import pytest

from _449 import PostOrderCodec, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "root, expected",
        [
            (
                    TreeNode(
                        2,
                        left=TreeNode(1),
                        right=TreeNode(3),
                    ),
                    "1|3|2"
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
                    TreeNode(1, right=TreeNode(2)),
                    "2|1"
            ),
            (
                    TreeNode(3, left=TreeNode(2)),
                    "2|3"
            ),
            (
                    TreeNode(2, right=TreeNode(3, right=TreeNode(4))),
                    "4|3|2"
            )
        ]
    )
    def test(self, root, expected):
        assert PostOrderCodec().serialize(root) == expected
        assert PostOrderCodec().deserialize(expected) == root
