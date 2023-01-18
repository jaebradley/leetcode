package problems;

/**
 * https://leetcode.com/problems/house-robber-iii/description/

 * algorithms
 * Medium (44.64%)
 * Total Accepted:    63.5K
 * Total Submissions: 142.1K
 * Testcase Example:  '[3,2,3,null,3,null,1]'


 The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.



 Determine the maximum amount of money the thief can rob tonight without alerting the police.


 Example 1:

 3
 / \
 2   3
 \   \
 3   1

 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.


 Example 2:

 3
 / \
 4   5
 / \   \
 1   3   1

 Maximum amount of money the thief can rob = 4 + 5 = 9.


 Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */

public class HouseRobberThree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int rob(TreeNode root) {
        int[] sums = calculateSums(root);
        return Math.max(sums[0], sums[1]);
    }

    private static int[] calculateSums(TreeNode node) {
        if (node == null) {
            return new int[2];
        }

        int[] left = calculateSums(node.left);
        int[] right = calculateSums(node.right);

        int[] amounts = new int[2];

        amounts[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        amounts[1] = node.val + left[0] + right[0];

        return amounts;
    }
}
