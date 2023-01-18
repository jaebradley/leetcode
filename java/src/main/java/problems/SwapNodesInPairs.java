package problems;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode firstNodeToSwap = current.next;
            ListNode secondNodeToSwap = current.next.next;
            firstNodeToSwap.next = secondNodeToSwap.next;
            current.next = secondNodeToSwap;
            current.next.next = firstNodeToSwap;
            current = current.next.next;
        }

        return dummy.next;
    }
}
