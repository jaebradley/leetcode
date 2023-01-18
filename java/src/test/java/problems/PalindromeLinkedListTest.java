package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.PalindromeLinkedList.*;

public class PalindromeLinkedListTest {

    @Test
    public void singleElementIsAPalindrome() {
        assertTrue(PalindromeLinkedList.isPalindrome(new ListNode(1)));
    }

    @Test
    public void twoIdenticalValuesAreAPalindrome() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        head.next = one;

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void twoDifferentValuesAreNotAPalindrome() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;

        assertFalse(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void threeValuesArePalindrome() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(1);
        head.next = one;
        one.next = two;

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void threeValuesAreNotAPalindrome() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        head.next = one;
        one.next = two;

        assertFalse(PalindromeLinkedList.isPalindrome(head));
    }
}