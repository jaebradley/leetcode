package problems;

/**
 * https://leetcode.com/problems/path-sum-iii/description/

 * algorithms
 * Easy (40.12%)
 * Total Accepted:    54.8K
 * Total Submissions: 136.6K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'

 You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards
 (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */

public class PathSum3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int pathSum(TreeNode root, int sum) {
        return pathSumCount(root, sum) + pathSumCount(root.left, sum) + pathSumCount(root.right, sum);
    }

    private static int pathSumCount(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int newSum = sum - node.val;

        return newSum == 0 ? 1 : pathSumCount(node.left, newSum) + pathSumCount(node.right, newSum);
    }
}
