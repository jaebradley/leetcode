package problems;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/

 * algorithms
 * Easy (33.42%)
 * Total Accepted:    153.9K
 * Total Submissions: 460.4K
 * Testcase Example:  '[]'

 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversedSlow = reverse(slow);
        fast = head;

        while (reversedSlow != null) {
            if (fast.val != reversedSlow.val) {
                return false;
            }
            fast = fast.next;
            reversedSlow = reversedSlow.next;
        }
        return true;

    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
