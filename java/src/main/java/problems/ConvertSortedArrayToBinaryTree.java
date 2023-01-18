package problems;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

 * algorithms
 * Easy (44.43%)
 * Total Accepted:    172.6K
 * Total Submissions: 386.3K
 * Testcase Example:  '[-10,-3,0,5,9]'

 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.




 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5
 */

public class ConvertSortedArrayToBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        int middle = nums[middleIndex];
        TreeNode root = new TreeNode(middle);
        root.right = helper(nums, middleIndex + 1, endIndex);
        root.left = helper(nums, startIndex, middleIndex - 1);
        return root;
    }
}
