import pytest

from _700 import RecursiveSolution, IterativeSolution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     4,
                     TreeNode(2, TreeNode(1), TreeNode(3)),
                     TreeNode(7)
                 ),
                 2
             ],
             TreeNode(2, TreeNode(1), TreeNode(3))),
            ([
                 TreeNode(
                     4,
                     TreeNode(2, TreeNode(1), TreeNode(3)),
                     TreeNode(7)
                 ),
                 5],
             None)
        ])
    def test(self, inputs, expected):
        for solution in [RecursiveSolution(), IterativeSolution()]:
            assert solution.searchBST(*inputs) == expected
