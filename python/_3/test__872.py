import pytest

from _872 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([TreeNode(1, TreeNode(3), TreeNode(2)), TreeNode(1, TreeNode(2, TreeNode(3)))], False),
            ([TreeNode(1, TreeNode(3), TreeNode(2)), TreeNode(1, TreeNode(3), TreeNode(2))], True),
        ])
    def test(self, inputs, expected):
        assert Solution().leafSimilar(*inputs) == expected
