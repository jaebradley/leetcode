"""
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
"""

from collections import deque
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


class BfsSolution:
    def lowest_common_ancestor(self, root: TreeNode, first: TreeNode, second: TreeNode) -> Optional[TreeNode]:
        if None is root or root == first or root == second:
            return root

        left_subtree_ancestor = self.lowest_common_ancestor(root.left, first, second)
        right_subtree_ancestor = self.lowest_common_ancestor(root.right, first, second)

        if left_subtree_ancestor is not None and right_subtree_ancestor is not None:
            return root

        if right_subtree_ancestor is not None:
            return right_subtree_ancestor

        return left_subtree_ancestor

    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        q = deque([root])
        left_most_node = root
        right_most_node = root
        while q:
            size = len(q)
            for i in range(size):
                current_node = q.pop()
                if 0 == i:
                    left_most_node = current_node

                if i == (size - 1):
                    right_most_node = current_node

                if current_node.left:
                    q.appendleft(current_node.left)

                if current_node.right:
                    q.appendleft(current_node.right)

        return self.lowest_common_ancestor(root, left_most_node, right_most_node)
