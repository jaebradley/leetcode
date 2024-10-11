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
    """
    
    """

    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self._generate_bst(1, n + 1)

    def _generate_bst(self, start: int, end: int) -> List[Optional[TreeNode]]:
        trees = []
        if start >= end:
            trees.append(None)
        else:
            for root in range(start, end):
                left_subtrees = self._generate_bst(start=start, end=root)
                right_subtrees = self._generate_bst(start=root + 1, end=end)
                for left_subtree in left_subtrees:
                    for right_subtree in right_subtrees:
                        trees.append(
                            TreeNode(
                                val=root,
                                left=left_subtree,
                                right=right_subtree
                            )
                        )

        return trees
