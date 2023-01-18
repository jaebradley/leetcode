package problems;

import org.junit.Test;
import problems.ReverseLinkedList.ListNode;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void emptyListShouldBeNull() {
        assertNull(ReverseLinkedList.reverseList(null));
    }

    @Test
    public void singleElementListShouldBeIdentical() {
        ListNode head = new ListNode(1);
        assertEquals(head, ReverseLinkedList.reverseList(head));
    }

    @Test
    public void multipleElementListShouldBeReversed() {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = one;
        one.next = two;
        two.next = three;

        ListNode reversed = ReverseLinkedList.reverseList(head);

        assertEquals(3, reversed.val);
        assertEquals(2, reversed.next.val);
        assertEquals(1, reversed.next.next.val);
        assertEquals(0, reversed.next.next.next.val);
        assertNull(reversed.next.next.next.next);
    }
}