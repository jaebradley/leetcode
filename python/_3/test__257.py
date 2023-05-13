import pytest

from _257 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (TreeNode(1), ["1"]),
            (TreeNode(
                1,
                TreeNode(2, None, TreeNode(5)),
                TreeNode(3)),
             ["1->2->5", "1-> 3"]),
        ])
    def test(self, input, expected):
        assert expected.sort() == Solution().binaryTreePaths(input).sort()
