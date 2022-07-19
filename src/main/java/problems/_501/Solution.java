package problems._501;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * <p>
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * <p>
 * If the tree has more than one mode, return them in any order.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Approach:
 * In-order traversal (L, Node, R) of a BST is basically like iterating over an array from lowest value to greatest value
 * Keep track of max count of same values, starting with MIN_INTEGER
 * Keep track of current value and current counts
 * If next value is equal to current value, add 1 to current count and compare against max count
 * If same as max count, add to results to return at end
 * If current count ever greater than max count, update results to only contain the value with max count
 * If there are many elements with the same count, then the results would contain all these elements
 * So space is O(n) in worst-case.
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

    private int currentModeCount = 0;
    private int maxCount = 0;
    private Optional<Integer> currentNodeValue = Optional.empty();
    private Set<Integer> currentModeNumbers = new HashSet<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        return currentModeNumbers
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void helper(final TreeNode node) {
        if (null != node) {
            helper(node.left);

            if (currentNodeValue.isPresent() && node.val == currentNodeValue.get()) {
                currentModeCount += 1;
            } else {
                currentModeCount = 1;
            }

            if (currentModeCount > maxCount) {
                currentModeNumbers = new HashSet<>();
            }

            if (currentModeCount >= maxCount) {
                currentModeNumbers.add(node.val);
            }

            maxCount = Math.max(maxCount, currentModeCount);
            currentNodeValue = Optional.of(node.val);

            helper(node.right);
        }
    }
}
