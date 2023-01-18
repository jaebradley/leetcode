package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.SwapNodesInPairs.*;

public class SwapNodesInPairsTest {

    @Test
    public void doesNotSwapForEmptyList() {
        assertNull(swapPairs(null));
    }

    @Test
    public void doesNotSwapForSingleElementList() {
        ListNode head = new ListNode(1);
        ListNode swappedList = swapPairs(head);
        assertEquals(1, swappedList.val);
        assertNull(swappedList.next);
    }

    @Test
    public void doesSwapForTwoElementList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode swappedList = swapPairs(head);
        assertEquals(2, swappedList.val);
        assertEquals(1, swappedList.next.val);
        assertNull(swappedList.next.next);
    }

    @Test
    public void doesNotSwapLastElementForThreeElementList() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        ListNode swappedList = swapPairs(head);
        assertEquals(2, swappedList.val);
        assertEquals(1, swappedList.next.val);
        assertEquals(3, swappedList.next.next.val);
        assertNull(swappedList.next.next.next);
    }
}