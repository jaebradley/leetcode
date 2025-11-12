"""
One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the
node's value. If it is a null node, we record using a sentinel value such as '#'.

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".
Note: You are not allowed to reconstruct the tree.
"""
class Solution:
    """
    Think of a valid binary tree as whether or not the tree has filled a certain number of slots.
    At the beginning of the tree, there's just one slot available for a number or null node.
    Null nodes do not add any slots whereas number adds two slots for child nodes.
    If the number of slots is not 0 at the end of iteration, then it's not a valid binary tree.
    """
    def isValidSerialization(self, preorder: str) -> bool:
        slots = 1
        for c in preorder.split(","):
            slots -= 1

            if 0 > slots:
                return False

            if c != "#":
                slots += 2

        return 0 == slots