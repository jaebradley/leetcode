import pytest

from _1448 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     3,
                     TreeNode(1, TreeNode(3)),
                     TreeNode(4, TreeNode(1), TreeNode(5))
                 )
             ],
             4),
            ([
                 TreeNode(
                     3,
                     TreeNode(3, TreeNode(4), TreeNode(2))
                 )],
             3),
            ([TreeNode(1)], 1)
        ])
    def test(self, inputs, expected):
        assert Solution().goodNodes(*inputs) == expected
