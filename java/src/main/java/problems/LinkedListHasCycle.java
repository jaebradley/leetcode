package problems;

import data.AnotherListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Given a linked list, determine if it has a cycle in it.
 */

public class LinkedListHasCycle {
    public static boolean hasCycle(AnotherListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        AnotherListNode first = head.next.next;
        AnotherListNode second = head.next;

        while (first != second) {
            if (first.next == null || first.next.next == null || second.next == null) {
                return false;
            }
            first = first.next.next;
            second = second.next;
        }

        return true;
    }
}
