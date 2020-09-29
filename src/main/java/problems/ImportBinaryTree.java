package problems;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 * Approach:
 *
 * 1. Inversion is simply swapping left and right nodes
 * 2. So for a given node, swap left and right, then go to the left node and recursively call the invert function
 * 3. Then for the right node, recursively call the invert function
 */

public class ImportBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
