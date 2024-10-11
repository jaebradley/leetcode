import pytest

from _199 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     1,
                     TreeNode(2, None, TreeNode(5)),
                     TreeNode(3, None, TreeNode(4)))
             ],
             [1, 3, 4]),
            ([TreeNode(1, None, TreeNode(3))], [1, 3]),
            ([None], [])
        ])
    def test(self, inputs, expected):
        assert Solution().rightSideView(*inputs) == expected
