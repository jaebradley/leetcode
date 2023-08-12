from typing import Optional, List


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
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        return self.calculate_leaves(root1, []) == self.calculate_leaves(root2, [])

    def calculate_leaves(self, root: TreeNode, leaves: List[int]):
        if root is None:
            return leaves

        if root.left is None and root.right is None:
            leaves.append(root.val)
            return leaves

        return self.calculate_leaves(root.right, self.calculate_leaves(root.left, leaves))
