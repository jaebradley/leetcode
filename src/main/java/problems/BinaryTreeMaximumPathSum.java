package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Example 2:
 * <p>
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 3 * 104].
 * -1000 <= Node.val <= 1000
 */

public class BinaryTreeMaximumPathSum {
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

    public int maxPathSum(final TreeNode root) {
        final Stack<TreeNode> postOrderedNodes = postOrder(root);
        int maximumSum = Integer.MIN_VALUE;
        final Map<TreeNode, Integer> maxSumFormedByBuildingTopToBottomPath = new HashMap<>();
        maxSumFormedByBuildingTopToBottomPath.put(null, 0);

        while (!postOrderedNodes.empty()) {
            final TreeNode currentNode = postOrderedNodes.pop();
            if (currentNode != null) {
                final Integer leftSum = maxSumFormedByBuildingTopToBottomPath.get(currentNode.left);
                final Integer rightSum = maxSumFormedByBuildingTopToBottomPath.get(currentNode.right);
                final int maxLeftSum = Math.max(leftSum, 0);
                final int maxRightSum = Math.max(rightSum, 0);
                final Integer maxPathSum = currentNode.val + Math.max(maxLeftSum, maxRightSum);
                final int maxValueAtNode = currentNode.val + maxLeftSum + maxRightSum;
                maximumSum = Math.max(maximumSum, maxValueAtNode);
                maxSumFormedByBuildingTopToBottomPath.put(currentNode, maxPathSum);
            }
        }

        return maximumSum;
    }

    private Stack<TreeNode> postOrder(final TreeNode root) {
        final Stack<TreeNode> output = new Stack<>();
        final Stack<TreeNode> holdingNodes = new Stack<>();

        holdingNodes.push(root);

        while (!holdingNodes.empty()) {
            final TreeNode currentNode = holdingNodes.pop();
            if (currentNode != null) {
                output.add(currentNode);

                if (currentNode.left != null) {
                    holdingNodes.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    holdingNodes.add(currentNode.right);
                }
            }
        }

        return output;
    }
}
