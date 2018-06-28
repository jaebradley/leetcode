package problems;

import org.junit.Test;
import problems.RotateList.ListNode;

import static org.junit.Assert.*;

public class RotateListTest {

    @Test
    public void rotateZeroTimes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode rotatedHead = RotateList.rotateRight(head, 0);
        assertEquals(rotatedHead.val, 1);
        assertEquals(rotatedHead.next.val, 2);
        assertNull(rotatedHead.next.next);
    }

    @Test
    public void rotateOnce() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode rotatedHead = RotateList.rotateRight(head, 1);
        assertEquals(rotatedHead.val, 2);
        assertEquals(rotatedHead.next.val, 1);
        assertNull(rotatedHead.next.next);
    }

    @Test
    public void rotateExactlyListLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode rotatedHead = RotateList.rotateRight(head, 2);
        assertEquals(rotatedHead.val, 1);
        assertEquals(rotatedHead.next.val, 2);
        assertNull(rotatedHead.next.next);
    }
}