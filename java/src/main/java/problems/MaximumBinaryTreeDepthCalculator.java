package problems;

import data.TreeNode;

/**
 * Calculate Maximum Binary Tree Depth (https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumBinaryTreeDepthCalculator {
    /**
     * Calculates the max depth, given a binary tree
     * @param root starting node of binary tree
     * @return an integer representing the max depth of the input binary tree
     */
    public static int calculateMaxDepth(TreeNode root) {
        return calculateMaxDepthForNode(root, 0);
    }

    /**
     * Calculates the max depth of the given binary tree node by recursively calling #calculateMaxDepthForNode on the
     * child nodes.
     *
     * If the current node is null, then the max depth is the current depth for that node.
     * If the current node exists
     * @param node a particular node in a binary tree
     * @param currentDepth a given depth value in a binary tree
     * @return maximum depth for a given node
     */

    public static int calculateMaxDepthForNode(TreeNode node, int currentDepth) {
        int maxLeftDepth = currentDepth;
        int maxRightDepth = currentDepth;

        if (node != null) {
            if (node.getLeft() != null) {
                maxLeftDepth = calculateMaxDepthForNode(node.getLeft(), currentDepth + 1);
            } else {
                maxLeftDepth += 1;
            }

            if (node.getRight() != null) {
                maxRightDepth = calculateMaxDepthForNode(node.getRight(), currentDepth + 1);
            } else {
                maxRightDepth += 1;
            }
        }


        return Math.max(maxLeftDepth, maxRightDepth);
    }
}
