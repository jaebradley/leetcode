package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/

 * algorithms
 * Easy (48.74%)
 * Total Accepted:    39.4K
 * Total Submissions: 80.7K
 * Testcase Example:  '[5,2,13]'

 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.


 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13

 */

public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode convertBSTRecursively(TreeNode root) {
        if (root != null) {
            convertBSTRecursively(root.right);

            int value = root.val;
            sum += value;

            root.val = sum;

            convertBSTRecursively(root.left);
        }

        return root;
    }

    public static TreeNode convertBSTIteratively(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();

        TreeNode node = root;

        int sum = 0;

        while (node != null || !nodes.empty()) {
            if (node != null) {
                nodes.push(node);
                node = node.right;
            } else {
                node = nodes.pop();
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
        }

        return root;
    }
}
