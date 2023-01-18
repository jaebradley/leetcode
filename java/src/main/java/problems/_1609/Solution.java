package problems._1609;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/even-odd-tree/
 *
 * A binary tree is named Even-Odd if it meets the following conditions:
 *
 *     The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 *     For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 *     For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 *
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
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

    public boolean isEvenOddTree(TreeNode root) {
        if (null == root) {
            return false;
        }

        boolean expectEvenValues = false;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            final Queue<TreeNode> nextNodes = new LinkedList<>();
            int previousNodeValue = expectEvenValues ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            while (!nodes.isEmpty()) {
                final TreeNode currentNode = nodes.remove();
                if (expectEvenValues) {
                    if (!(currentNode.val < previousNodeValue)) {
                        return false;
                    }
                } else {
                    if (!(currentNode.val > previousNodeValue)) {
                        return false;
                    }
                }

                final boolean isCurrentValueEven = (0 == (currentNode.val % 2));
                if ((expectEvenValues && !isCurrentValueEven) || (!expectEvenValues && isCurrentValueEven)) {
                    return false;
                }

                previousNodeValue = currentNode.val;
                if (null != currentNode.left) {
                    nextNodes.add(currentNode.left);
                }

                if (null != currentNode.right) {
                    nextNodes.add(currentNode.right);
                }
            }
            nodes = nextNodes;
            expectEvenValues = !expectEvenValues;
        }

        return true;
    }
}
