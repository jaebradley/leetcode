package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/

 * algorithms
 * Medium (49.55%)
 * Total Accepted:    273.9K
 * Total Submissions: 551.3K
 * Testcase Example:  '[1,null,2,3]'

 Given a binary tree, return the inorder traversal of its nodes' values.


 For example:
 Given binary tree [1,null,2,3],

 1
 \
 2
 /
 3



 return [1,3,2].


 Note: Recursive solution is trivial, could you do it iteratively?
 */

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> traversedValues = new Stack<>();

        TreeNode node = root;

        while (node != null || !traversedValues.empty()) {
            while (node != null) {
                traversedValues.push(node);
                node = node.left;
            }
            node = traversedValues.pop();
            values.add(node.val);
            node = node.right;
        }

        return values;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverseTreeRecursively(root, values);
        return values;
    }

    private static void traverseTreeRecursively(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) {
                traverseTreeRecursively(node.left, values);
            }

            values.add(node.val);

            if (node.right != null) {
                traverseTreeRecursively(node.right, values);
            }
        }


    }
}
