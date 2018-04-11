package problems;

import org.junit.Test;
import problems.LinkedListCycle2.ListNode;

import static org.junit.Assert.*;

public class LinkedListCycle2Test {
    @Test
    public void nullForLinkedListWithoutACycle() {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);

        head.next = first;
        first.next = second;
        second.next = third;

        assertNull(LinkedListCycle2.detectCycle(head));
    }

    @Test
    public void notNullForLinkedListWithCycle() {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = first;

        assertEquals(first, LinkedListCycle2.detectCycle(head));
    }

}