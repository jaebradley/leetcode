package problems._1339;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Initial approach is to do 1 pass to calculate total sum (as well as sums at each node)
 * At each node, determine whether removing the right or left branches sums
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public int maxProduct(final TreeNode root) {
        final Map<TreeNode, Integer> sumsByNode = new HashMap<>();
        final int totalSum = calculateTotalSum(root, sumsByNode);
        final AtomicLong maxProduct = new AtomicLong(0);
        calculateMaxProduct(root, totalSum, maxProduct, sumsByNode);
        return (int) (maxProduct.get() % (1e9 + 7));
    }

    private static int calculateTotalSum(final TreeNode currentNode,
                                         final Map<TreeNode, Integer> sumsByNode) {
        if (null != currentNode) {
            final int leftSum = calculateTotalSum(currentNode.left, sumsByNode);
            final int rightSum = calculateTotalSum(currentNode.right, sumsByNode);
            final int nodeSum = leftSum + rightSum + currentNode.val;
            sumsByNode.put(currentNode, nodeSum);
            return nodeSum;
        }

        return 0;
    }

    private static void calculateMaxProduct(
            final TreeNode currentNode,
            final int totalSum,
            final AtomicLong maxProduct,
            final Map<TreeNode, Integer> sumsByNode
    ) {
        if (null != currentNode) {
            calculateMaxProduct(currentNode.left, totalSum, maxProduct, sumsByNode);
            calculateMaxProduct(currentNode.right, totalSum, maxProduct, sumsByNode);

            final int leftSum = sumsByNode.getOrDefault(currentNode.left, 0);
            final int rightSum = sumsByNode.getOrDefault(currentNode.right, 0);
            final int currentSum = leftSum + rightSum + currentNode.val;
            final int remainingTreeSum = totalSum - currentSum;
            maxProduct.set(
                    Math.max(
                            maxProduct.get(),
                            (long) remainingTreeSum * currentSum
                    )
            );
        }
    }
}
