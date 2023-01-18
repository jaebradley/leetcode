package problems._508;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * <p>
 * Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
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

    public int[] findFrequentTreeSum(TreeNode root) {
        final Map<Integer, Integer> countsBySum = new HashMap<>();
        helper(root, countsBySum);
        return countsBySum
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(maxValue -> countsBySum.entrySet().stream().filter(e -> e.getValue().equals(maxValue)))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private static int helper(final TreeNode currentNode, final Map<Integer, Integer> countsBySum) {
        if (null != currentNode) {
            final int leftSum = helper(currentNode.left, countsBySum);
            final int rightSum = helper(currentNode.right, countsBySum);
            final int sum = leftSum + rightSum + currentNode.val;
            countsBySum.compute(
                    sum,
                    (key, value) -> Optional.ofNullable(value).map(v -> v + 1).orElse(1)
            );
            return sum;
        }

        return 0;
    }
}
