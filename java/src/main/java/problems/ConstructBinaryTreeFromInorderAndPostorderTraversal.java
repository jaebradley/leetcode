package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

 * algorithms
 * Medium (33.52%)
 * Total Accepted:    106.8K
 * Total Submissions: 316.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'

 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given


 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]

 Return the following binary tree:


 3
 / \
 9  20
 /  \
 15   7
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMapping = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMapping.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, postorder.length - 1, inorderMapping, inorder, postorder);
    }

    private static TreeNode helper(int inorderStart, int inorderEnd, int postorderEnd, Map<Integer, Integer> inorderMapping, int[] inorder, int[] postorder) {
        if (inorderStart > inorderEnd || postorderEnd < 0) {
            return null;
        }

        int nodeValue = postorder[postorderEnd];
        int inorderNodeIndex = inorderMapping.get(nodeValue);

        TreeNode node = new TreeNode(nodeValue);

        node.left = helper(inorderStart, inorderNodeIndex - 1, postorderEnd - 1 - inorderEnd + inorderNodeIndex, inorderMapping, inorder, postorder);
        node.right = helper(inorderNodeIndex + 1, inorderEnd, postorderEnd - 1, inorderMapping, inorder, postorder);

        return node;
    }
}
