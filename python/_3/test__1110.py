import pytest

from _1110 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     1,
                     TreeNode(2, TreeNode(4), TreeNode(5)),
                     TreeNode(3, TreeNode(6), TreeNode(7))
                 ),
                 [3, 5]
             ],
             [
                 TreeNode(
                     1,
                     TreeNode(2, TreeNode(4)),
                 ),
                 TreeNode(6),
                 TreeNode(7)
             ]),
            ([
                 TreeNode(
                     1,
                     TreeNode(2, TreeNode(4)),
                     TreeNode(3)
                 ),
                 [3]
             ],
             [
                 TreeNode(
                     1,
                     TreeNode(2, TreeNode(4))
                 ),
             ])
        ])
    def test(self, inputs, expected):
        assert Solution().delNodes(*inputs) == expected
