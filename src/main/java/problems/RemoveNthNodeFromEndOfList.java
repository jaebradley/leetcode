package problems;

import data.AnotherListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Given n will always be valid.
 */

public class RemoveNthNodeFromEndOfList {

    /**
     * Use two pointers to keep track of where to delete node.
     * The first pointer will take n steps forward. Then the first and second pointers take 1 step at a time until the
     * first pointer gets to the end of the list.
     *
     * The second pointer should now be at the node before the node to delete. So by reassigning the second pointer's next
     * value, we should be able to delete the specified node.
     *
     * To support deleting the head node, we create a new start node that we assign the head to next.
     */
    public static AnotherListNode removeNthFromEnd(AnotherListNode head, int n) {
        AnotherListNode start = new AnotherListNode(0);
        start.next = head;
        AnotherListNode slow = start;
        AnotherListNode fast = start;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
