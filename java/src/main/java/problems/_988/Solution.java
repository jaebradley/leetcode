package problems._988;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * <p>
 * You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
 * <p>
 * Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * As a reminder, any shorter prefix of a string is lexicographically smaller.
 * <p>
 * For example, "ab" is lexicographically smaller than "aba".
 * <p>
 * A leaf of a node is a node that has no children.
 * <p>
 * Approach:
 * Top-down approach via pre-order traversal (Root, Left, Right)
 * If current node is non-null, calculate current node string value
 * If current node is leaf, and current node string value is less than current smallest value, replace it
 * Calculate left and right subtrees
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

    public String smallestFromLeaf(TreeNode root) {
        final AtomicReference<String> smallest = new AtomicReference<>("|");
        helper(root, "", smallest);
        return smallest.get();
    }

    private static void helper(final TreeNode currentRoot, final String previous, final AtomicReference<String> smallest) {
        if (null != currentRoot) {
            final String current = Character.toString('a' + currentRoot.val) + previous;
            if (null == currentRoot.left && null == currentRoot.right && 0 < smallest.get().compareTo(current)) {
                smallest.set(current);
            }

            helper(currentRoot.left, current, smallest);
            helper(currentRoot.right, current, smallest);
        }
    }
}
