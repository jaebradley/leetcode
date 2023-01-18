package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.SortList.*;

public class SortListTest {

    @Test
    public void nullForEmptyList() {
        assertNull(SortList.sortList(null));
    }

    @Test
    public void doesNotChangeSingleList() {
        assertEquals(1, SortList.sortList(new ListNode(1)).val);
    }

    @Test
    public void sortList() {
        ListNode head = new ListNode(-1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(0);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode sortedList = SortList.sortList(head);

        assertEquals(-1, sortedList.val);
        assertEquals(0, sortedList.next.val);
        assertEquals(3, sortedList.next.next.val);
        assertEquals(4, sortedList.next.next.next.val);
        assertEquals(5, sortedList.next.next.next.next.val);
    }

    @Test
    public void doesNotChangeSortedList() {
        ListNode head = new ListNode(-1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode sortedList = SortList.sortList(head);

        assertEquals(-1, sortedList.val);
        assertEquals(0, sortedList.next.val);
        assertEquals(3, sortedList.next.next.val);
        assertEquals(4, sortedList.next.next.next.val);
        assertEquals(5, sortedList.next.next.next.next.val);
    }
}