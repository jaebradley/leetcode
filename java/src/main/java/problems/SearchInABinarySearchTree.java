package problems;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 *
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * Approach:
 *
 * 1. Recursive approach could be something like, if current value is null, return null
 * 2. If current value is non-null, if search value is greater than current value, search right tree and return if a
 *    non-null node is found
 * 3. If search value is less than current value, search left tree, and return if a non-null node is found
 * 4. Else, return current value
 */

public class SearchInABinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val > root.val) {
            return this.searchBST(root.right, val);
        } else {
            return this.searchBST(root.left, val);
        }
    }
}
