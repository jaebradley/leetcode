package problems;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * Approach:
 *
 * 1. Can be recursive where sum of left leaves for node is sum of sum of left leaves for left and right subtrees
 * 2. For a given node, if it is not null, check the left child to see if it is a leaf, and if it is, to return that value
 * 3. If the left and right nodes are not leaves, then recursively sum the left leaves of those subtrees
 */

public class SumOfLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return 0;
        }

        return helper(root);
    }

    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node.left)) {
            return node.left.val + helper(node.right);
        }

        return helper(node.left) + helper(node.right);
    }

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
