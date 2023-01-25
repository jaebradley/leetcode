"""
https://leetcode.com/problems/invert-binary-tree/description/
"""

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
        return False


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None

        left_subtree = root.left
        right_subtree = root.right

        root.left = self.invertTree(right_subtree)
        root.right = self.invertTree(left_subtree)

        return root
