import pytest

from _450 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([
                 TreeNode(
                     val=5,
                     left=TreeNode(
                         3,
                         left=TreeNode(2),
                         right=TreeNode(4)
                     ),
                     right=TreeNode(
                         6,
                         right=TreeNode(7)
                     )
                 ),
                 3
             ],
             TreeNode(
                 val=5,
                 left=TreeNode(
                     4,
                     left=TreeNode(2)
                 ),
                 right=TreeNode(
                     6,
                     right=TreeNode(7)
                 )
             ),
            ),
            ([None, 0], None),
            ([TreeNode(0), 0], None),
            ([
                 TreeNode(
                     val=5,
                     left=TreeNode(
                         3,
                         left=TreeNode(2),
                         right=TreeNode(4)
                     ),
                     right=TreeNode(
                         6,
                         right=TreeNode(7)
                     )
                 ),
                 0
             ],
             TreeNode(
                 val=5,
                 left=TreeNode(
                     3,
                     left=TreeNode(2),
                     right=TreeNode(4)
                 ),
                 right=TreeNode(
                     6,
                     right=TreeNode(7)
                 )
             )
            )
        ])
    def test(self, arguments, expected):
        assert Solution().deleteNode(*arguments) == expected
