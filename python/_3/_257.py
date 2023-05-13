from collections import deque
from typing import Optional, List, Set


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BfsSolution:
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


class DfsSolution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        paths = set([])
        self.helper(root, str(root.val), paths)
        return list(paths)

    def helper(self, root: Optional[TreeNode], current_path: str, paths: Set[str]):
        if root is not None:
            if root.left is None and root.right is None:
                paths.add(current_path)
            else:
                if root.left is not None:
                    self.helper(root.left, current_path + "->" + str(root.left.val), paths)
                if root.right is not None:
                    self.helper(root.right, current_path + "->" + str(root.right.val), paths)
