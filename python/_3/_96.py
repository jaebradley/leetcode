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
    The number of unique BSTs for some number X is the sum of all the unique BSTs for each number 1 through X as the root.
    The number of unique BSTs when some number Y is the root is Unique BSTs(i - 1) * Unique BSTs(Y - i) for 1 <= i <= Y.

    The number of BSTs with the number 3 as root for 1-7 inclusive is
    (Left Subtree) [1, 2] * (Right Subtree) [4, 5, 6 , 7] = Unique BSTs(2) * Unique BSTs(4)
    """

    def numTrees(self, n: int) -> int:
        # dp is 0-indexed, but index 0 = unique BSTs for node count of 1
        dp = [0] * (1 + n)
        dp[0] = 1
        dp[1] = 1

        for current_node_index in range(2, 1 + n):
            for offset in range(1, 1 + current_node_index):
                dp[current_node_index] += (dp[current_node_index - offset] * dp[offset - 1])

        return dp[n]
