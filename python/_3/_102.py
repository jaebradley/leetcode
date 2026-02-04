"""
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
"""
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
        return False


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        values = []

        q = deque([root])

        while q:
            current_size = len(q)
            current_level_values = []

            for _ in range(current_size):
                current_element = q.popleft()

                if current_element is not None:
                    q.append(current_element.left)
                    q.append(current_element.right)

                    current_level_values.append(current_element.val)

            if 0 < len(current_level_values):
                values.append(current_level_values)

        return values
