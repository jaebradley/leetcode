from hashlib import md5


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class RecursiveSolution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False
        if self.helper(current_root=root, current_comparison_root=subRoot):
            return True
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def helper(self, current_root: Optional[TreeNode], current_comparison_root: Optional[TreeNode]) -> bool:
        if current_root is None and current_comparison_root is None:
            return True

        if current_root is None or current_comparison_root is None:
            return False

        return current_root.val == current_comparison_root.val \
            and self.helper(current_root.left, current_comparison_root.left) \
            and self.helper(current_root.right, current_comparison_root.right)


class MerkleTreeSolution:
    """
    hash of
    * left node merkle value
    * current node value
    * right node merkle value
    """

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        self.merkle(root)
        self.merkle(subRoot)

        def dfs(current_node: Optional[TreeNode]):
            if not current_node:
                return False
            return current_node.merkle == subRoot.merkle or dfs(current_node.left) or dfs(current_node.right)

        return dfs(root)

    def merkle(self, node: Optional[TreeNode]):
        if node:
            left = self.merkle(node.left)
            right = self.merkle(node.right)
            hashed_value = md5(f"{left}{node.val}{right}".encode("ascii")).hexdigest()
            node.merkle = hashed_value
            return hashed_value

        return "#"
