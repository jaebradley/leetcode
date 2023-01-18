package problems;

import data.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */

public class IntersectionOfTwoLinkedLists {
    /**
     * The idea is to iterate through both lists until you get to the end. Then move pointers to the opposite list and start
     * iterating again.
     *
     * If the lists are different sizes, the fact that the lists are switched will "equalize" on the second iteration.
     *
     * So on the second iteration, if the lists itersect, the pointers should be equal at some point.
     * If the lists don't itersect, then the pointers will make it to the end of the list and return null
     */
    public static ListNode<Integer> getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode<Integer> first = headA;
        ListNode<Integer> second = headB;

        while (first != second) {
            if (first == null) {
                first = headB;
            } else {
                first = first.getNext();
            }

            if (second == null) {
                second = headA;
            } else {
                second = second.getNext();
            }
        }

        return first;
    }
}
