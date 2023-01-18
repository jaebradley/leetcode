package problems;

import data.TreeNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 *
 * Approach:
 *
 * 1. Recursive solution is something like, iterate through input numbers to find index of greatest value
 * 2. Create node with this value and then separate the two subarrays and recursively call the construct method with
 *    the specified subarrays.
 * 3. Assign the resultant trees to the left and right references on the generated TreeNode
 */

public class MaximumBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            TreeNode treeNode = (TreeNode) obj;

            return Objects.equals(val, treeNode.val)
                    && Objects.equals(left, treeNode.left)
                    && Objects.equals(right, treeNode.right);
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int maxValueIndex = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValueIndex = i;
                maxValue = nums[i];
            }
        }

        return new TreeNode(
                maxValue,
                this.constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxValueIndex )),
                this.constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxValueIndex + 1, nums.length))
        );
    }
}
