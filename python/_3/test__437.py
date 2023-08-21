import pytest

from _437 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     10,
                     TreeNode(5,
                              TreeNode(3, TreeNode(3), TreeNode(-2)),
                              TreeNode(2, None, TreeNode(1))),
                     TreeNode(-3,
                              None,
                              TreeNode(11))),
                 8
             ],
             3),
            ([
                 TreeNode(1, None, TreeNode(2, None, TreeNode(3, None, TreeNode(4, None, TreeNode(5))))),
                 3
             ],
             2),
        ])
    def test(self, inputs, expected):
        assert Solution().pathSum(*inputs) == expected
