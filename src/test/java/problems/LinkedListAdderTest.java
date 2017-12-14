package problems;

import data.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListAdderTest {

    @Test
    public void testEmptySums() {
        assertNull(LinkedListAdder.addTwoNumbers(null, null));
    }

    @Test
    public void testSingleValue() {
        assertEquals(LinkedListAdder.addTwoNumbers(new ListNode<>(0, null), null), new ListNode<>(0, null));
    }
}