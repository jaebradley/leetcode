package problems;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/

 * algorithms
 * Easy (38.39%)
 * Total Accepted:    221K
 * Total Submissions: 575.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:


 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:


 3
 / \
 9  20
 /  \
 15   7

 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:


 1
 / \
 2   2
 / \
 3   3
 / \
 4   4


 Return false.
 */

public class BalancedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.right), depth(node.left)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
