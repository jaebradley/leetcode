package problems._889;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * <p>
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 * <p>
 * If there exist multiple answers, you can return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * Example 2:
 * <p>
 * Input: preorder = [1], postorder = [1]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * All the values of preorder are unique.
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * All the values of postorder are unique.
 * It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
 */

import java.util.Objects;

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        final int[] indexByPreorderValue = new int[preorder.length + 1];
        for (int index = 0; index < preorder.length; index += 1) {
            indexByPreorderValue[preorder[index]] = index;
        }

        final int[] indexByPostorderValue = new int[postorder.length + 1];
        for (int index = 0; index < postorder.length; index += 1) {
            indexByPostorderValue[postorder[index]] = index;
        }

        return helper(
                0,
                preorder.length - 1,
                postorder.length - 1,
                indexByPreorderValue,
                preorder,
                postorder
        );
    }

    private static TreeNode helper(
            int preorderStartIndex,
            int preorderEndIndex,
            int postorderEndIndex,
            int[] indexByPreorderValue,
            int[] preorder,
            int[] postorder
    ) {
        if (preorderStartIndex > preorderEndIndex) {
            return null;
        }

        final TreeNode node = new TreeNode(preorder[preorderStartIndex]);

        if (preorderStartIndex < preorderEndIndex) {
            final int leftSubtreePreorderIndex = preorderStartIndex + 1;
            final int rightSubtreeValue = postorder[postorderEndIndex - 1];
            final int rightSubtreePreorderIndex = indexByPreorderValue[rightSubtreeValue];

            node.left = helper(
                    leftSubtreePreorderIndex,
                    rightSubtreePreorderIndex - 1,
                    postorderEndIndex - 1,
                    indexByPreorderValue,
                    preorder,
                    postorder
            );
            node.right = helper(
                    rightSubtreePreorderIndex,
                    preorderEndIndex,
                    postorderEndIndex - 1,
                    indexByPreorderValue,
                    preorder,
                    postorder
            );
        }

        return node;
    }
}
