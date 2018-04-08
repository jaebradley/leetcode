package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/

 * algorithms
 * Medium (46.75%)
 * Total Accepted:    225.3K
 * Total Submissions: 481.2K
 * Testcase Example:  '[1,null,2,3]'

 Given a binary tree, return the preorder traversal (root, left, right) of its nodes' values.


 For example:
 Given binary tree [1,null,2,3],

 1
 \
 2
 /
 3



 return [1,2,3].


 Note: Recursive solution is trivial, could you do it iteratively?
 */

public class PreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> traversedNodes = new Stack<>();

        TreeNode node = root;

        while (node != null || !traversedNodes.empty()) {
            if (node != null) {
                values.add(node.val);
                traversedNodes.push(node.right);
                node = node.left;
            } else {
                node = traversedNodes.pop();
            }
        }

        return values;
    }

    public static List<Integer> preorderTraversalRecursively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverseRecursively(root, values);
        return values;
    }

    private static void traverseRecursively(TreeNode node, List<Integer> values) {
        if (node != null) {
            values.add(node.val);

            if (node.left != null) {
                traverseRecursively(node.left, values);
            }

            if (node.right != null) {
                traverseRecursively(node.right, values);
            }
        }
    }
}
