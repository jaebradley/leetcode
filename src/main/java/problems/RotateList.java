package problems;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode currentNode = head;
        ListNode tail = currentNode;

        while (currentNode != null) {
            length++;
            tail = currentNode;
            currentNode = currentNode.next;
        }
        tail.next = head;

        currentNode = head;
        for (int i = 0; i < k % length; i++) {
            tail = currentNode;
            currentNode = currentNode.next;
        }

        tail.next = null;

        return currentNode;
    }
}
