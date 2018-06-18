package problems;

/**
 * https://leetcode.com/problems/sort-list/description/
 *
 * * algorithms
 * * Medium (30.41%)
 * * Total Accepted:    137.4K
 * * Total Submissions: 450.4K
 * * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 *
 * Example 2:
 *
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Use a merge-sort strategy to sort the linked list.
     *
     * First, separate the list into two halves - do this by using two pointers and have the "fast" pointer move two
     * steps at a time.
     *
     * Note that the "previous" pointer is keeping track of the first (i.e. "slow") half. It is important that the
     * "previous" pointer assigns it's next value to null - this will prevent the "slow" half from duplicating the same
     * work over and over again.
     *
     * Next, recursively split the list (and it's sublists) into halves, and then merge these halves by iterating
     * through each pair of halves and adding them to a new list based on the order of the values.
     */

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;

        ListNode firstHalfSorted = sortList(head);
        ListNode secondHalfSorted = sortList(slow);

        return merge(firstHalfSorted, secondHalfSorted);
    }

    private static ListNode merge(ListNode firstList, ListNode secondList) {
        ListNode mergedList = new ListNode(0);
        ListNode currentMergedNode = mergedList;

        while (firstList != null && secondList != null) {
            if (firstList.val <= secondList.val) {
                currentMergedNode.next = firstList;
                firstList = firstList.next;
            } else {
                currentMergedNode.next = secondList;
                secondList = secondList.next;
            }
            currentMergedNode = currentMergedNode.next;
        }

        if (firstList != null) {
            currentMergedNode.next = firstList;
        } else {
            currentMergedNode.next = secondList;
        }

        return mergedList.next;
    }
}
