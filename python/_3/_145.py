# Definition for a binary tree node.
from typing import Optional, List


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
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        values = []

        def helper(current_node: Optional[TreeNode], values: List[int]):
            if current_node is not None:
                helper(current_node.left, values)
                helper(current_node.right, values)
                values.append(current_node.val)

        helper(root, values)

        return values
