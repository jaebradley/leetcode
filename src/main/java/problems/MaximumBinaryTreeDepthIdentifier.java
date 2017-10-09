package problems;

import data.TreeNode;

public class MaximumBinaryTreeDepthIdentifier {
    public static int identifyMaxDepth(TreeNode root) {
        return identifyMaxDepthForNode(root, 0);
    }

    public static int identifyMaxDepthForNode(TreeNode node, int currentDepth) {
        int maxLeftDepth = currentDepth;
        int maxRightDepth = currentDepth;

        if (node != null) {
            if (node.getLeft() != null) {
                maxLeftDepth = identifyMaxDepthForNode(node.getLeft(), currentDepth + 1);
            } else {
                maxLeftDepth += 1;
            }

            if (node.getRight() != null) {
                maxRightDepth = identifyMaxDepthForNode(node.getRight(), currentDepth + 1);
            } else {
                maxRightDepth += 1;
            }
        }


        return Math.max(maxLeftDepth, maxRightDepth);
    }
}
