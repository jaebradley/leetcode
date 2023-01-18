package problems;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Approach:
 *
 * 1. Create a new ListNode that represents the merged list
 * 2. Evaluate the first ListNode value vs. the second ListNode value - whichever is smaller should be added to the
 *    merged list and then that node should be incremented
 */


public class MergeTwoSortedLists {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode merged = new ListNode();
    ListNode head = merged;

    while (l1 != null || l2 != null) {
      if (l1 == null) {
        merged.next = new ListNode(l2.val);
        l2 = l2.next;
      } else if (l2 == null) {
        merged.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        if (l1.val < l2.val) {
          merged.next = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          merged.next = new ListNode(l2.val);
          l2 = l2.next;
        }
      }
      merged = merged.next;
    }

    return head.next;
  }
}
