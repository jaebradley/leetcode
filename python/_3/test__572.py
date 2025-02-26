import pytest

from _572 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(3, left=TreeNode(4, TreeNode(1), TreeNode(2)), right=TreeNode(5)),
                 TreeNode(4, TreeNode(1), TreeNode(2))
             ],
             True),
            ([
                 TreeNode(3, left=TreeNode(4, TreeNode(1), TreeNode(2, left=TreeNode(0))), right=TreeNode(5)),
                 TreeNode(4, TreeNode(1), TreeNode(2))
             ],
             False),
            ([
                 TreeNode(3, left=TreeNode(4, TreeNode(1)), right=TreeNode(5, left=TreeNode(2))),
                 TreeNode(3, TreeNode(1), TreeNode(2))
             ],
             False),
        ])
    def test(self, inputs, expected):
        assert Solution().isSubtree(*inputs) == expected
