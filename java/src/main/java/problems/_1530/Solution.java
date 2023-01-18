package problems._1530;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * <p>
 * You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.
 * <p>
 * Return the number of good leaf node pairs in the tree.
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

    public int countPairs(final TreeNode root, final int distance) {
        final AtomicInteger count = new AtomicInteger(0);
        helper(root, distance, count);
        return count.get();
    }

    private static List<Integer> helper(final TreeNode currentNode, final int distance, final AtomicInteger count) {
        if (null != currentNode) {
            if (null == currentNode.left && null == currentNode.right) {
                return List.of(1);
            }

            final List<Integer> leftChildLeafDistances = helper(currentNode.left, distance, count);
            final List<Integer> rightChildLeafDistances = helper(currentNode.right, distance, count);

            leftChildLeafDistances.forEach(
                    leftChildLeafDistance -> rightChildLeafDistances.forEach(
                            rightChildLeafDistance -> {
                                if ((leftChildLeafDistance + rightChildLeafDistance) <= distance) {
                                    count.getAndIncrement();
                                }
                            }
                    )
            );

            return Stream.concat(
                            leftChildLeafDistances.stream(),
                            rightChildLeafDistances.stream()
                    )
                    .map(v -> 1 + v)
                    .filter(v -> v <= distance)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
