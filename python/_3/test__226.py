import pytest

from _226 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (None, None),
            (TreeNode(0, TreeNode(1), TreeNode(2)), TreeNode(0, TreeNode(2), TreeNode(1))),
            (TreeNode(0, TreeNode(1), None), TreeNode(0, None, TreeNode(1))),
            (TreeNode(0, None, TreeNode(1)), TreeNode(0, TreeNode(1), None)),
            (TreeNode(0), TreeNode(0))
        ])
    def test(self, input, expected):
        assert expected == Solution().invertTree(input)
