package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/

 * algorithms
 * Hard (42.08%)
 * Total Accepted:    175.8K
 * Total Submissions: 416.6K
 * Testcase Example:  '[1,null,2,3]'

 Given a binary tree, return the postorder (left, right, root) traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],


 1
 \
 2
 /
 3




 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */

public class PostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> postOrderTraversalIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        if (root == null) {
            return values;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty()) {
            TreeNode node = s1.pop();

            if (node.left != null) {
                s1.push(node.left);
            }

            if (node.right != null) {
                s1.push(node.right);
            }

            s2.push(node);
        }

        while (!s2.empty()) {
            values.add(s2.pop().val);
        }

        return values;
    }

    public static List<Integer> postorderTraversalRecursively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        recursiveTraversal(root, values);
        return values;
    }

    private static void recursiveTraversal(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) {
                recursiveTraversal(node.left, values);
            }

            if (node.right != null) {
                recursiveTraversal(node.right, values);
            }

            values.add(node.val);
        }
    }
}
