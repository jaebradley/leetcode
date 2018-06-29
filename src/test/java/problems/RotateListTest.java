package problems;

import org.junit.Test;
import problems.RotateList.ListNode;

import static org.junit.Assert.*;

public class RotateListTest {

    @Test
    public void rotateZeroTimes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode rotatedHead = RotateList.rotateRight(head, 0);
        assertEquals(rotatedHead.val, 1);
        assertEquals(rotatedHead.next.val, 2);
        assertEquals(rotatedHead.next.next.val, 3);
        assertEquals(rotatedHead.next.next.next.val, 4);
        assertNull(rotatedHead.next.next.next.next);
    }

    @Test
    public void rotateOnce() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode rotatedHead = RotateList.rotateRight(head, 1);
        assertEquals(rotatedHead.val, 4);
        assertEquals(rotatedHead.next.val, 1);
        assertEquals(rotatedHead.next.next.val, 2);
        assertEquals(rotatedHead.next.next.next.val, 3);
        assertNull(rotatedHead.next.next.next.next);
    }

    @Test
    public void rotateExactlyListLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode rotatedHead = RotateList.rotateRight(head, 4);
        assertEquals(rotatedHead.val, 1);
        assertEquals(rotatedHead.next.val, 2);
        assertEquals(rotatedHead.next.next.val, 3);
        assertEquals(rotatedHead.next.next.next.val, 4);
        assertNull(rotatedHead.next.next.next.next);
    }

    @Test
    public void rotateGreaterThanListLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode rotatedHead = RotateList.rotateRight(head, 5);
        assertEquals(rotatedHead.val, 4);
        assertEquals(rotatedHead.next.val, 1);
        assertEquals(rotatedHead.next.next.val, 2);
        assertEquals(rotatedHead.next.next.next.val, 3);
        assertNull(rotatedHead.next.next.next.next);
    }

    @Test
    public void rotateForEmptyList() {
        assertNull(RotateList.rotateRight(null, 10));
    }

    @Test
    public void rotateForSingleElementList() {
        ListNode head = new ListNode(1);
        ListNode rotatedHead = RotateList.rotateRight(head, 10);
        assertEquals(rotatedHead.val, 1);
        assertNull(rotatedHead.next);
    }
}