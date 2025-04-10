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


class RecursiveSolution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        values = []

        def helper(current_node: Optional[TreeNode], values: List[int]):
            if current_node is not None:
                helper(current_node.left, values)
                helper(current_node.right, values)
                values.append(current_node.val)

        helper(root, values)

        return values


class IterativeSolution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        head, stack, values = root, [root], []
        while stack:
            next_node = stack[-1]
            is_leaf = next_node.left is None and next_node.right is None
            has_finished_processing_subtree = next_node.left == head or next_node.right == head
            # if node is a leaf node, we want to write the value
            # since head points to the next_node value, if the next node in the stack then references the most recently
            # popped off value, this means that the node's subtrees have been processed.
            # This is true since the right subtree will be pushed onto the stack first
            # think of the trivial case of a single root node with a left and a right element
            # stack will look like [left, right, root]
            # only when left and right have both been published will root.left/right == head
            if is_leaf or has_finished_processing_subtree:
                values.append(next_node.val)
                stack.pop()
                head = next_node
            else:
                if next_node.right:
                    stack.append(next_node.right)
                if next_node.left:
                    stack.append(next_node.left)

        return values
