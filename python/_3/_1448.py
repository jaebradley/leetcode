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
    def goodNodes(self, root: TreeNode) -> int:
        return self.helper(root, float("-infinity"))

    def helper(self, current_node: TreeNode, current_maximum_path_value: int) -> int:
        if current_node is None:
            return 0

        current_node_modifier = 1 if current_node.val >= current_maximum_path_value else 0
        return self.helper(current_node.left, max(current_maximum_path_value, current_node.val)) \
            + self.helper(current_node.right, max(current_maximum_path_value, current_node.val)) \
            + current_node_modifier
