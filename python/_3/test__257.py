import pytest

from _257 import BfsSolution, DfsSolution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (TreeNode(1), ["1"]),
            (TreeNode(
                1,
                TreeNode(2, None, TreeNode(5)),
                TreeNode(3)),
             ["1->2->5", "1->3"]),
        ])
    def test(self, input, expected):
        for solution in [DfsSolution(), BfsSolution()]:
            expected.sort()
            paths = solution.binaryTreePaths(input)
            paths.sort()
            assert expected == paths
