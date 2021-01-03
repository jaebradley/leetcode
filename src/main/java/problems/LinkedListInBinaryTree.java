package problems;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 * <p>
 * Given a binary tree root and a linked list with head as the first node.
 * <p>
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 * <p>
 * In this context downward path means a path that starts at some node and goes downwards.
 * <p>
 * Example 1:
 * Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: true
 * Explanation: Nodes in blue form a subpath in the binary Tree.
 * <p>
 * Example 2:
 * Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: true
 * Example 3:
 * <p>
 * Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: false
 * Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
 * <p>
 * Approach:
 * <p>
 * 1. Recursive subproblem can be applied to child trees - does linked list exist as a subpath in child trees?
 * 2. Recursion is something like
 * * Check if root value is equal to head value - if so, get next nodes and compare them, calling the function recursively
 * * If the result of the function is true, return true
 * * If the result of the function is false, return false
 * * If the root value is not equal to the head value, check the subpaths of the children
 */

public class LinkedListInBinaryTree {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubPath(final ListNode head, final TreeNode root) {
        if (null == head) {
            return true;
        }

        if (null == root) {
            return false;
        }

        return checkSubPathCandidate(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkSubPathCandidate(final ListNode head, final TreeNode root) {
        if (null == head) {
            return true;
        }

        if (null == root) {
            return false;
        }

        return head.val == root.val && (checkSubPathCandidate(head.next, root.left) || checkSubPathCandidate(head.next, root.right));
    }
}
