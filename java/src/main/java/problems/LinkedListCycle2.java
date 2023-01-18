package problems;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/

 * algorithms
 * Medium (30.63%)
 * Total Accepted:    144.7K
 * Total Submissions: 472.9K


 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.



 Note: Do not modify the linked list.


 Follow up:
 Can you solve it without using extra space?
 */

public class LinkedListCycle2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**

     2.1) L1 is defined as the distance between the head point and entry point

     2.2) L2 is defined as the distance between the entry point and the meeting point

     2.3) C is defined as the length of the cycle

     2.4) n is defined as the travel times of the fast pointer around the cycle When the first encounter of the slow pointer and the fast pointer

     According to the definition of L1, L2 and C, we can obtain:

     the total distance of the slow pointer traveled when encounter is L1 + L2

     the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C

     Because the total distance the fast pointer traveled is twice as the slow pointer, Thus:

     2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1) C + (C - L2)*

     Because it will take C - L2 steps (or L1) steps to get to the start of the cycle, walking from the start and the
     meeting place will meet at cycle entry

     **/

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode first = head.next.next;
        ListNode second = head.next;

        while (first != second) {
            if (first.next == null || first.next.next == null || second.next == null) {
                return null;
            }
            first = first.next.next;
            second = second.next;
        }

        second = head;

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }
}
