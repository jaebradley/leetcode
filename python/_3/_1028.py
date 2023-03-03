"""
https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
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
    """
    Pre-order is Root, Left, Right.

    If # of elements in the stack are greater than the current level pop the stack until the # of elements in the stack
    are NOT greater than the current level.

    At this point, all the elements in the stack have been added to their parent (as the left) - if the # of elements in
    the stack are greater than the current level, the current node is some type of right node (finished progressing down left subtree).

    All that should be left after traversing through entire string is right subtree, so need to pop elements in right subtree
    until at the root.
    """

    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        current_index = 0
        stack = []

        while current_index < len(traversal):
            current_level = 0
            while current_index < len(traversal) and "-" == traversal[current_index]:
                current_index += 1
                current_level += 1

            current_value = ""
            while current_index < len(traversal) and "-" != traversal[current_index]:
                current_value += traversal[current_index]
                current_index += 1

            current_node = TreeNode(val=int(current_value))
            while len(stack) > current_level:
                stack.pop()

            top = stack[-1] if stack else None
            if top is not None:
                if top.left is None:
                    top.left = current_node
                else:
                    top.right = current_node

            stack.append(current_node)

        root = None
        while stack:
            root = stack.pop()
        return root
