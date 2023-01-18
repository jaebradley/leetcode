package problems._687;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 * <p>
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of the path between two nodes is represented by the number of edges between them.
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

    public int longestUnivaluePath(TreeNode root) {
        final AtomicInteger maxCount = new AtomicInteger(0);
        helper(root, maxCount);
        return maxCount.get();
    }

    private static int helper(
            final TreeNode currentNode,
            final AtomicInteger maxCount
    ) {
        if (null != currentNode) {
            final List<Integer> pathSums = Stream.of(
                            Optional.ofNullable(currentNode.left),
                            Optional.ofNullable(currentNode.right)
                    )
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(node -> Map.entry(node.val, helper(node, maxCount)))
                    .filter(e -> e.getKey().equals(currentNode.val))
                    .map(e -> 1 + e.getValue())
                    .collect(Collectors.toList());

                maxCount.set(Math.max(maxCount.get(), pathSums.stream().reduce(0, Integer::sum)));
                return pathSums.stream().max(Integer::compareTo).orElse(0);
            }

        return 0;
    }
}
