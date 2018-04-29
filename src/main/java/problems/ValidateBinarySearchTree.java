package problems;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/

 * algorithms
 * Medium (24.07%)
 * Total Accepted:    236.8K
 * Total Submissions: 983.4K
 * Testcase Example:  '[2,1,3]'

 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:


 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:


 Input:
 2
 / \
 1   3
 Output: true


 Example 2:


 5
 / \
 1   4
 / \
 3   6
 Output: false
 Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 is 5 but its right child's value is 4.
 */

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isValidBSTRecursive(TreeNode root) {
        return isValidBSTRecursiveHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTRecursiveHelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return root.val < max && root.val > min
                && isValidBSTRecursiveHelper(root.left, min, root.val)
                && isValidBSTRecursiveHelper(root.right, root.val, max);


    }
}
