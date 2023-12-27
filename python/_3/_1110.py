from typing import Optional, List, Set


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
    """
    If a current node has no parent, and isn't deleted, then add it to roots
    """

    ROOTS = []

    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        Solution.ROOTS = []

        self.helper(current_node=root, to_delete=set(to_delete), has_deleted_parent=True)

        return Solution.ROOTS

    def helper(self, current_node: Optional[TreeNode], to_delete: Set[int], has_deleted_parent: bool):
        if current_node is not None:
            should_delete_node = current_node.val in to_delete
            if has_deleted_parent and not should_delete_node:
                Solution.ROOTS.append(current_node)

            current_node.left = self.helper(current_node=current_node.left, to_delete=to_delete, has_deleted_parent=should_delete_node)
            current_node.right = self.helper(current_node=current_node.right, to_delete=to_delete, has_deleted_parent=should_delete_node)

            return None if should_delete_node else current_node

        return None
