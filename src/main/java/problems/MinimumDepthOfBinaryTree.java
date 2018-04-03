package problems;

/**
 * https://leetcode.com/problems/same-tree/description/

 * algorithms
 * Easy (47.72%)
 * Total Accepted:    260.4K
 * Total Submissions: 545.6K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'


 Given two binary trees, write a function to check if they are the same or not.


 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.




 Example 1:

 Input:     1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 Output: true



 Example 2:

 Input:     1         1
 /           \
 2             2

 [1,2],     [1,null,2]

 Output: false



 Example 3:

 Input:     1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false
 */

public class MinimumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
