package problems._951;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 * <p>
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 * <p>
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 * <p>
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 * <p>
 * Approach:
 * <p>
 * If current node 1 and current node 2 are not the same, return false
 * If current node 1 and current node 2 are the same, recursively call function for left and right children for current node
 * If one of the functions returns false, swap the children
 * If still returns false, return false, else return true
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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }

        if ((null != root1 && null != root2) && (root1.val == root2.val)) {
            return (
                    flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                            || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
            );
        }
        return false;
    }
}
