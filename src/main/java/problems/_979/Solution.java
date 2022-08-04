package problems._979;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Post-order traversal (Left, Right, Current Node).
 * Leaves should then have the "balance" of coins following post-order traversal order.
 * For some leaves, this "balance" will be positive, meaning they have a surplus of coins that they need to distribute
 * to other nodes. In this case, the number of moves will be the number of surplus coins at this node.
 * For some leaves, this "balance" will be negative, meaning they need to receive coins. In this case, the number of
 * moves is the number of necessary coins at this node.
 * Number of moves = surplus coins or necessary coins from left + surplus coins or necessary coins from right
 * Surplus / necessary coins is the number of coins at the current node - 1 (coin to keep) + surplus / necessary coins
 * from left / right nodes.
 */

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int distributeCoins(TreeNode root) {
        final AtomicInteger count = new AtomicInteger(0);
        helper(root, count);
        return count.get();
    }

    private static int helper(final TreeNode node, final AtomicInteger count) {
        if (null != node) {
            final int leftBalance = helper(node.left, count);
            final int rightBalance = helper(node.right, count);
            count.addAndGet(Math.abs(leftBalance));
            count.addAndGet(Math.abs(rightBalance));
            return leftBalance + rightBalance + node.val - 1;
        }
        return 0;
    }
}
