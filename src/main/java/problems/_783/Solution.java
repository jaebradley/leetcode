package problems._783;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Inorder traversal (L, Root, Right) implies that values are processed smallest to largest for a BST.
 * Identifying the min difference of children / child and returning min of min difference processing left and then right
 * vs. min of comparing against left and right roots specifically.
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
    }

    private int result = Integer.MAX_VALUE;
    private Integer previousNodeValue = null;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(final TreeNode currentNode) {
        if (null == currentNode) {
            return;
        }

        helper(currentNode.left);

        if (null != previousNodeValue) {
            result = Math.min(result, currentNode.val - previousNodeValue);
        }

        previousNodeValue = currentNode.val;

        helper(currentNode.right);
    }
}
