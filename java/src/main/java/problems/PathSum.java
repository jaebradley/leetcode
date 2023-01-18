package problems;


/**
 * https://leetcode.com/problems/path-sum/description/

 * algorithms
 * Easy (34.87%)
 * Total Accepted:    211.5K
 * Total Submissions: 606.1K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'

 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,


 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1


 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean hasRootToLeafSum(TreeNode node, int sum, int currentSum) {
        if (node == null) {
            return false;
        }

        int nextSum = currentSum + node.val;

        if (node.left == null && node.right == null) {
            return sum ==  nextSum;
        }

        return hasRootToLeafSum(node.left, sum, nextSum) || hasRootToLeafSum(node.right, sum, nextSum);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasRootToLeafSum(root, sum, 0);

    }
}
