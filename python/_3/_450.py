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


class Solution:
    """
    Step 1: Find the node (if it exists)
    If current node = target, start deletion process

    if target > current node, check right subtree
    if target < current node, check left subtree

    Step 2: Deletion process
    Every node has single parent
    So need reference to parent node
    Every node has 0-2 children
    If node has 0 children, remove the node from the parent, substitute with None
    If node has 1 child, remove the node from the parent, substitute with child
    If node has 2 children
      Everything in left subtree should be less than anything in the right subtree
      So traverse left subtree of right subtree, and tack on the left child as a child to the left-most leaf of the
      right subtree

    """

    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: return None

        if root.val == key:
            # case 1: leaf node
            if not root.left and not root.right: return None

            # case 2: only 1 of left or right child present
            if not root.left: return root.right
            if not root.right: return root.left

            # case 3: both children
            curr = root.right
            # move to to the leftmost child of the right sub-tree (that will be next bigger)
            while curr.left: curr = curr.left
            # swap the value with the root node (i.e delete root)
            root.val = curr.val
            # now delete the leftmost child from the right sub-tree
            root.right = self.deleteNode(root.right, curr.val)

        elif key < root.val:
            # find the key in left sub-tree and delete it
            root.left = self.deleteNode(root.left, key)
        else:
            # find the key in right sub-tree and delete it
            root.right = self.deleteNode(root.right, key)

        return root
