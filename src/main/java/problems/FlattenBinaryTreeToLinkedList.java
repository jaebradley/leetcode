package problems;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

 * algorithms
 * Medium (36.48%)
 * Total Accepted:    163.7K
 * Total Submissions: 447.7K
 * Testcase Example:  '[1,2,5,3,4,null,6]'

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given


 1
 / \
 2   5
 / \   \
 3   4   6




 The flattened tree should look like:


 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6


 click to show hints.

 Hints:

 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void flatten(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            flatten(root.left);
            flatten(root.right);

            root.left = null;
            root.right = left;

            TreeNode current = root;
            while (current.right != null) {
                current = current.right;
            }

            current.right = right;
        }
    }
}
