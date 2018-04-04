package problems;

/**
 * https://leetcode.com/problems/symmetric-tree/description/

 * algorithms
 * Easy (40.33%)
 * Total Accepted:    243.5K
 * Total Submissions: 603.3K
 * Testcase Example:  '[1,2,2,3,4,4,3]'

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).


 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3



 But the following [1,2,2,null,3,null,3]  is not:

 1
 / \
 2   2
 \   \
 3    3




 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean nodesAreEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        return node1.val == node2.val
                && nodesAreEqual(node1.left, node2.right)
                && nodesAreEqual(node1.right, node2.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || nodesAreEqual(root.left, root.right);

    }
}
