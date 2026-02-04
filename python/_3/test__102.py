import pytest

from _102 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "root, expected",
        [
            (
                    None,
                    []
            ),
            (
                    TreeNode(1),
                    [[1]]
            ),
            (
                    TreeNode(1, TreeNode(2), TreeNode(3)),
                    [[1], [2, 3]]
            ),
        ])
    def test(self, root, expected):
        assert Solution().levelOrder(root) == expected
