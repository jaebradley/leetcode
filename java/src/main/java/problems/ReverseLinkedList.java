package problems;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/

 * algorithms
 * Easy (46.70%)
 * Total Accepted:    336K
 * Total Submissions: 719.4K
 * Testcase Example:  '[]'

 Reverse a singly linked list.

 click to show more hints.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
