"""
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
"""


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


class RecursiveSolution:
    """
    Level order traversal, keep reference to parent
    If all the parents in a level is the same, then that parent is the deepest node
    """

    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        return self.helper(root)[1]

    def helper(self, root: TreeNode) -> (int, TreeNode):
        if None is root:
            return 0, TreeNode

        left_depth, left_subtree = self.helper(root.left)
        right_depth, right_subtree = self.helper(root.right)

        if left_depth > right_depth:
            return 1 + left_depth, left_subtree

        if right_depth > left_depth:
            return 1 + right_depth, right_subtree

        return 1 + left_depth, root
