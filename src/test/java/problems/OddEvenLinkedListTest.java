package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.OddEvenLinkedList.*;

public class OddEvenLinkedListTest {
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
    }
}