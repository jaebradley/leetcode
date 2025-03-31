import pytest

from _145 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (
                    TreeNode(1, None, TreeNode(2, TreeNode(3))),
                    [3, 2, 1]
            ),
            (
                    TreeNode(1,
                             TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))),
                             TreeNode(3, None, TreeNode(8, TreeNode(9)))
                             ),
                    [4, 6, 7, 5, 2, 9, 8, 3, 1]
            ),
            (
                    None,
                    []
            )
        ])
    def test(self, input, expected):
        assert Solution().postorderTraversal(input) == expected
