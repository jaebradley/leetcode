from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __eq__(self, other):
        """Overrides the default implementation"""
        if isinstance(other, TreeNode):
            return self.val == other.val and self.left == other.left and self.right == other.right


class Solution:
    longest_zigzag = float("-infinity")

    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        Solution.longest_zigzag = float("-infinity")

        max(Solution.longest_zigzag, self.helper(root, True))

        return Solution.longest_zigzag

    def helper(self, root: Optional[TreeNode], is_left: bool) -> int:
        if root is None:
            return 0

        left_right = self.helper(root.left, False)
        right_left = self.helper(root.right, True)

        Solution.longest_zigzag = max(Solution.longest_zigzag, max([left_right, right_left]))

        if is_left:
            return 1 + left_right

        return 1 + right_left
