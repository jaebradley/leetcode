from collections import deque
from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        paths = []
        if root is not None:
            q = deque([[root, str(root.val)]])
            while q:
                size = len(q)
                for _ in range(size):
                    current_node, path = q.popleft()
                    if current_node.left is None and current_node.right is None:
                        paths.append(path)
                    else:
                        if current_node.left is not None:
                            q.append([current_node.left, path + "->" + str(current_node.left.val)])
                        if current_node.right is not None:
                            q.append([current_node.right, path + "->" + str(current_node.right.val)])

        return paths
