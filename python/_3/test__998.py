import pytest

from _998 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ((TreeNode(4, TreeNode(1), TreeNode(3, TreeNode(2))), 5),
             TreeNode(5, TreeNode(4, TreeNode(1), TreeNode(3, TreeNode(2))))),
            ((TreeNode(5, TreeNode(2, None, TreeNode(1)), TreeNode(4)), 3),
             TreeNode(5, TreeNode(2, None, TreeNode(1)), TreeNode(4, None, TreeNode(3)))),
            ((TreeNode(5, TreeNode(2, None, TreeNode(1)), TreeNode(3)), 4),
             TreeNode(5, TreeNode(2, None, TreeNode(1)), TreeNode(4, TreeNode(3), None)))
        ])
    def test(self, inputs, expected):
        assert Solution().insertIntoMaxTree(*inputs) == expected
