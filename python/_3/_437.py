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
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if root is None:
            return 0

        return self.helper(root, targetSum) + self.pathSum(root.left, targetSum) + self.pathSum(root.right, targetSum)

    def helper(self, root: Optional[TreeNode], target_sum: int) -> int:
        if root is None:
            return 0

        return (root.val == target_sum) \
            + self.helper(root.right, target_sum - root.val) \
            + self.helper(root.left, target_sum - root.val)
