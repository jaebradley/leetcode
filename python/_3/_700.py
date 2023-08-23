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


class RecursiveSolution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root is not None:
            if root.val == val:
                return root

            if root.val > val:
                return self.searchBST(root.left, val)

            return self.searchBST(root.right, val)

        return None


class IterativeSolution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        current_node = root
        while current_node:
            if current_node.val > val:
                current_node = current_node.left
            elif current_node.val < val:
                current_node = current_node.right
            else:
                return current_node

        return None
