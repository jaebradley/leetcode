import pytest

from _865 import RecursiveSolution, TreeNode, BfsSolution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (TreeNode(1), TreeNode(1)),
            (TreeNode(
                0,
                TreeNode(1, None, TreeNode(2)),
                TreeNode(3)),
             TreeNode(2)),
            (
                    TreeNode(
                        3,
                        TreeNode(
                            5,
                            TreeNode(6),
                            TreeNode(2, TreeNode(7), TreeNode(4))
                        ),
                        TreeNode(1, TreeNode(0), TreeNode(8))
                    ),
                    TreeNode(2, TreeNode(7), TreeNode(4))
            ),
            (
                    TreeNode(
                        3,
                        TreeNode(
                            5,
                            TreeNode(6),
                            TreeNode(2, TreeNode(7), TreeNode(4))
                        ),
                        TreeNode(1, TreeNode(0), TreeNode(8, TreeNode(9), TreeNode(10)))
                    ),
                    TreeNode(
                        3,
                        TreeNode(
                            5,
                            TreeNode(6),
                            TreeNode(2, TreeNode(7), TreeNode(4))
                        ),
                        TreeNode(1, TreeNode(0), TreeNode(8, TreeNode(9), TreeNode(10)))
                    )
            )
        ])
    def test(self, input, expected):
        for solution in [RecursiveSolution(), BfsSolution()]:
            assert expected == solution.subtreeWithAllDeepest(input)
