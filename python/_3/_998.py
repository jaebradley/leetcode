# Definition for a binary tree node.
from typing import Optional


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


"""
A maximum tree is a tree where every node has a value greater than any other value in its subtree.

You are given the root of a maximum binary tree and an integer val.

Just as in the [previous problem](https://leetcode.com/problems/maximum-binary-tree/), the given tree was constructed from a list a (root = Construct(a)) recursively with the following Construct(a) routine:

If a is empty, return null.
Otherwise, let a[i] be the largest element of a. Create a root node with the value a[i].
The left child of root will be Construct([a[0], a[1], ..., a[i - 1]]).
The right child of root will be Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]).
Return root.
Note that we were not given a directly, only a root node root = Construct(a).

Suppose b is a copy of a with the value val appended to it. It is guaranteed that b has unique values.

Return Construct(b).

 

Example 1:
Input: root = [4,1,3,null,null,2], val = 5
Output: [5,4,null,1,3,null,null,2]
Explanation: a = [1,4,2,3], b = [1,4,2,3,5]

Example 2:
Input: root = [5,2,4,null,1], val = 3
Output: [5,2,4,null,1,null,3]
Explanation: a = [2,1,5,4], b = [2,1,5,4,3]

Example 3:
Input: root = [5,2,3,null,1], val = 4
Output: [5,2,4,null,1,3]
Explanation: a = [2,1,5,3], b = [2,1,5,3,4]

Constraints:
The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 100
All the values of the tree are unique.
1 <= val <= 100
"""


class Solution:
    """
    Recursion:
    If root is None, then return TreeNode(val).
    If val is not greater than root.val, then recursively check the right branch.
    This is because "let a[i] be the largest element of a." implies that new smaller characters will be inserted into
    the right branch.
    If val is greater than the root.val, then make a TreeNode with val as the value and root as the left subtree.
    """

    def insertIntoMaxTree(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root is None:
            return TreeNode(val)

        if root.val > val:
            root.right = self.insertIntoMaxTree(root.right, val)
        else:
            root = TreeNode(val, root)

        return root
