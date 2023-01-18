package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

 * algorithms
 * Medium (45.24%)
 * Total Accepted:    140.8K
 * Total Submissions: 310.3K
 * Testcase Example:  '[1]\n1'

 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Credits:Special thanks to @ts for adding this problem and creating all test cases.
 */

public class KthSmallestElementInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();

        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            k--;
            root = nodes.pop();
            if (k <= 0) {
                return root.val;
            }
            root = root.right;
        }

        return Integer.MIN_VALUE;
    }
}
