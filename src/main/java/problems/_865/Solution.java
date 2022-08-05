package problems._865;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 *
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 *
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
 *
 * Approach:
 * If node is null, return passed in depth
 * If node is non-null, calculate current depth as passed in depth + 1
 * Calculate left and right node depths - if depths are greater than or equal to current max depth, update current max
 * depth, and evaluate diff between current depth and max depth.
 * If diff between current depth and max depth is smaller than previous minimum, set candidate node to current node
 * O(n), O(n) stack
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).getValue();
    }

    private static Map.Entry<Integer, TreeNode> helper(final TreeNode currentNode) {
        if (null != currentNode) {
            final Map.Entry<Integer, TreeNode> leftNodeAndDepth = helper(currentNode.left);
            final Map.Entry<Integer, TreeNode> rightNodeAndDepth = helper(currentNode.right);
            final int depth = Math.max(leftNodeAndDepth.getKey(), rightNodeAndDepth.getKey());
            final TreeNode node;
            {
                if (leftNodeAndDepth.getKey().equals(rightNodeAndDepth.getKey())) {
                    node = currentNode;
                } else if (leftNodeAndDepth.getKey().compareTo(rightNodeAndDepth.getKey()) < 0) {
                    node = rightNodeAndDepth.getValue();
                } else {
                    node = leftNodeAndDepth.getValue();
                }
            }

            return Map.entry(1 + depth, node);
        }

        return Map.entry(0, new TreeNode(Integer.MAX_VALUE));
    }
}
