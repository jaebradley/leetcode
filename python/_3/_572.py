# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False
        if self.helper(current_root=root, current_comparison_root=subRoot):
            return True
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def helper(self, current_root: Optional[TreeNode], current_comparison_root: Optional[TreeNode]) -> bool:
        if current_root is None and current_comparison_root is None:
            return True

        if current_root is None or current_comparison_root is None:
            return False

        return current_root.val == current_comparison_root.val \
            and self.helper(current_root.left, current_comparison_root.left) \
            and self.helper(current_root.right, current_comparison_root.right)
