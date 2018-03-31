package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.OddEvenLinkedList.*;

public class OddEvenLinkedListTest {

    @Test
    public void testEmptyList() {
        assertNull(OddEvenLinkedList.oddEvenList(null));
    }

    @Test
    public void testSingleElementList() {
        ListNode head = new ListNode(1);
        assertEquals(OddEvenLinkedList.oddEvenList(head), head);
    }

    @Test
    public void testDoubleElementList() {
        ListNode two = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = two;
        ListNode listNode = OddEvenLinkedList.oddEvenList(head);
        assertEquals(listNode.val, 1);
        assertEquals(listNode.next.val, 2);
        assertNull(listNode.next.next);
    }

    @Test
    public void testFiveElementList() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode listNode = OddEvenLinkedList.oddEvenList(head);
        assertEquals(listNode.val, 1);
        assertEquals(listNode.next.val, 3);
        assertEquals(listNode.next.next.val, 5);
        assertEquals(listNode.next.next.next.val, 2);
        assertEquals(listNode.next.next.next.next.val, 4);
        assertNull(listNode.next.next.next.next.next);
    }
}