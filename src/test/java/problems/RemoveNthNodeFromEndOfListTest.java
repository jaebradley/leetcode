package problems;

import data.AnotherListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void itShouldRemove2ndNodeFromEnd() {
        AnotherListNode head = new AnotherListNode(1);
        AnotherListNode head1 = new AnotherListNode(2);
        AnotherListNode head2 = new AnotherListNode(3);
        AnotherListNode head3 = new AnotherListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;

        AnotherListNode expected = new AnotherListNode(1);
        AnotherListNode expected1 = new AnotherListNode(2);
        AnotherListNode expected2 = new AnotherListNode(4);
        expected.next = expected1;
        expected1.next = expected2;
        expected2.next = null;

        assertEquals(expected, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 2));
    }

    @Test
    public void itShouldRemoveHead() {
        AnotherListNode head = new AnotherListNode(1);
        AnotherListNode head1 = new AnotherListNode(2);
        AnotherListNode head2 = new AnotherListNode(3);
        AnotherListNode head3 = new AnotherListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;

        assertEquals(head1, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 4));
    }

    @Test
    public void itShouldRemoveNodeForSingleList() {
        AnotherListNode head = new AnotherListNode(1);
        assertEquals(null, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1));
    }

    @Test
    public void itShouldBeConstructed() {
        assertNotNull(new RemoveNthNodeFromEndOfList());
    }
}