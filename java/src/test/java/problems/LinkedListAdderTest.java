package problems;

import data.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListAdderTest {

    private final ListNode<Integer> singleDigit = new ListNode<>(9, null);
    private final ListNode<Integer> anotherSingleDigit = new ListNode<>(2, null);
    private final ListNode<Integer> five = new ListNode<>(5, null);
    private final ListNode<Integer> twoDigits = new ListNode<>(9, singleDigit);

    @Test
    public void testEmptySums() {
        assertNull(LinkedListAdder.addTwoNumbers(null, null));
    }

    @Test
    public void testSingleValue() {
        assertEquals(LinkedListAdder.addTwoNumbers(new ListNode<>(0, null), null), new ListNode<>(0, null));
    }

    @Test
    public void testCarryOverDigit() {
        ListNode<Integer> next = new ListNode<>(1, null);
        ListNode<Integer> expected = new ListNode<>(8, next);
        assertEquals(LinkedListAdder.addTwoNumbers(singleDigit, singleDigit), expected);
    }

    @Test
    public void testSingleDigitSum() {
        ListNode<Integer> expected = new ListNode<>(4, null);
        assertEquals(LinkedListAdder.addTwoNumbers(anotherSingleDigit, anotherSingleDigit), expected);
    }

    @Test
    public void testOneAsCarryOver() {
        ListNode<Integer> next = new ListNode<>(1, null);
        ListNode<Integer> expected = new ListNode<>(0, next);
        assertEquals(LinkedListAdder.addTwoNumbers(five, five), expected);
    }

    @Test
    public void testSingleDigitAndMultipleDigitSum() {
        ListNode<Integer> last = new ListNode<>(1, null);
        ListNode<Integer> middle = new ListNode<>(0, last);
        ListNode<Integer> expected = new ListNode<>(8, middle);
        assertEquals(LinkedListAdder.addTwoNumbers(singleDigit, twoDigits), expected);
    }
}