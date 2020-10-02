package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 * Approach:
 * 1. Inorder traversal is left, parent, right
 * 2. Method checks if node argument is null - if so, it does not push to output List. If it is not null, it recursively
 *    calls left node.
 * 3. Then push current value to list.
 * 4. Then recursively call right node.
 */

public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }

    private static List<Integer> traverse(TreeNode node, List<Integer> values) {
        if (node == null) {
            return values;
        }

        List<Integer> updatedValues = traverse(node.left, values);
        updatedValues.add(node.val);
        updatedValues = traverse(node.right, updatedValues);
        return updatedValues;
    }
}
