package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

 * algorithms
 * Medium (34.02%)
 * Total Accepted:    136.4K
 * Total Submissions: 400.1K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'

 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given


 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]

 Return the following binary tree:


 3
 / \
 9  20
 /  \
 15   7
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * The idea is that the first value in the preorder represents the root value since it's root, left, right.
     * We can use this value and the inorder values to find all the values to the left and right of the root since it's
     * left, root, right.
     *
     * We can continue to do this, recursively, for each subarray.
     */

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderValues = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderValues.put(inorder[i], i);
        }

        return helper(0, 0, inorder.length - 1, preorder, inorder, inorderValues);
    }

    private static TreeNode helper(
            int preorderStart,
            int inorderStart,
            int inorderEnd,
            int[] preorder,
            int[] inorder,
            Map<Integer, Integer> inorderValues
    ) {
        if (preorderStart > preorder.length || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);
        Integer rootIndexInorder = inorderValues.get(preorder[preorderStart]);

        TreeNode left = helper(
                preorderStart + 1,
                inorderStart,
                rootIndexInorder - 1,
                preorder,
                inorder,
                inorderValues
        );
        TreeNode right = helper(
                preorderStart + rootIndexInorder - inorderStart + 1,
                rootIndexInorder + 1,
                inorderEnd,
                preorder,
                inorder,
                inorderValues
        );

        root.left = left;
        root.right = right;

        return root;
    }
}
