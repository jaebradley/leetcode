package problems;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/

 * algorithms
 * Easy (44.94%)
 * Total Accepted:    54.8K
 * Total Submissions: 122K
 * Testcase Example:  '[1,2,3,4,5]'


 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.



 Example:
 Given a binary tree

 1
 / \
 2   3
 / \
 4   5



 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].


 Note:
 The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {
    private int maxDepth;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * The maximum diameter of a node is the max depth of the left node and the max depth of the right node, plus 1.
     *
     * If this diameter is greater than the global maximum diameter, replace it.
     *
     * The maximum depth of a node is the maximum depth of either the left node or the right node, plus 1.
     */

    private int calculateMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateMaxDepth(node.left);
        int rightDepth = calculateMaxDepth(node.right);

        maxDepth = Math.max(maxDepth, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth = 1;

        calculateMaxDepth(root);

        return maxDepth - 1;
    }
}
