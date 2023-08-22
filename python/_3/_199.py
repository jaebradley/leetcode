from collections import deque
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


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        results = []
        if root:
            q = deque([root])
            while q:
                level_count_minus_one = max(0, len(q) - 1)
                for _ in range(level_count_minus_one):
                    current_node = q.pop()
                    if current_node.left:
                        q.appendleft(current_node.left)
                    if current_node.right:
                        q.appendleft(current_node.right)

                last_node_in_level = q.pop()
                results.append(last_node_in_level.val)

                if last_node_in_level.left:
                    q.appendleft(last_node_in_level.left)
                if last_node_in_level.right:
                    q.appendleft(last_node_in_level.right)

        return results
