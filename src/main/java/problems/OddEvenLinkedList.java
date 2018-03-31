package problems;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/

 * algorithms
 * Testcase Example:  '[1,2,3,4,5,6,7,8]'

 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.


 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.


 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...


 Credits:Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode currentOdd = head;
        ListNode evenHead = new ListNode(0);
        ListNode currentEven = evenHead;

        while (currentOdd.next != null) {
            currentEven.next = currentOdd.next;
            currentOdd.next = currentOdd.next.next;
            currentEven = currentEven.next;
            currentOdd = currentOdd.next;
        }

        currentOdd.next = evenHead.next;

        return head;
    }
}
