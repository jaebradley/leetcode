package problems;

import data.AnotherListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LinkedListHasCycleTest {
    @Test
    public void itShouldReturnTrueForCycle() {
        AnotherListNode head = new AnotherListNode(1);
        AnotherListNode head1 = new AnotherListNode(2);
        AnotherListNode head2 = new AnotherListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head;
        assertTrue(LinkedListHasCycle.hasCycle(head));
    }

    @Test
    public void itShouldReturnFalseForListWithoutACycle() {
        AnotherListNode head = new AnotherListNode(1);
        AnotherListNode head1 = new AnotherListNode(2);
        AnotherListNode head2 = new AnotherListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = null;
        assertFalse(LinkedListHasCycle.hasCycle(head));
    }

    @Test
    public void itShouldReturnFalseForNullHead() {
        assertFalse(LinkedListHasCycle.hasCycle(null));
    }

    @Test
    public void itShouldReturnFalseForHeadWithNullNext() {
        assertFalse(LinkedListHasCycle.hasCycle(new AnotherListNode(1)));
    }

    @Test
    public void itShouldReturnFalseForHeadWithNullNextNext() {
        assertFalse(LinkedListHasCycle.hasCycle(new AnotherListNode(1, new AnotherListNode(2))));
    }

    @Test
    public void itShouldConstruct() {
        assertNotNull(new LinkedListHasCycle());
    }
}