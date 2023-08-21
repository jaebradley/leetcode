import pytest

from _236 import InitialRecursiveSolution, RecursiveSolution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     3,
                     TreeNode(5,
                              TreeNode(6),
                              TreeNode(2, TreeNode(7), TreeNode(4))),
                     TreeNode(1,
                              TreeNode(0),
                              TreeNode(8))),
                 TreeNode(5,
                          TreeNode(6),
                          TreeNode(2, TreeNode(7), TreeNode(4))),
                 TreeNode(1,
                          TreeNode(0),
                          TreeNode(8))
             ],
             TreeNode(
                 3,
                 TreeNode(5,
                          TreeNode(6),
                          TreeNode(2, TreeNode(7), TreeNode(4))),
                 TreeNode(1,
                          TreeNode(0),
                          TreeNode(8)))
            ),
            ([
                 TreeNode(
                     3,
                     TreeNode(5,
                              TreeNode(6),
                              TreeNode(2, TreeNode(7), TreeNode(4))),
                     TreeNode(1,
                              TreeNode(0),
                              TreeNode(8))),
                 TreeNode(5,
                          TreeNode(6),
                          TreeNode(2, TreeNode(7), TreeNode(4))),
                 TreeNode(4)
             ],
             TreeNode(5,
                      TreeNode(6),
                      TreeNode(2, TreeNode(7), TreeNode(4)))
            ),
        ])
    def test(self, inputs, expected):
        for solution in [InitialRecursiveSolution(), RecursiveSolution()]:
            solution.lowestCommonAncestor(*inputs) == expected
