package problems;

import data.ListNode;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class LinkedListAdder {
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        return sum(l1, l2, 0);
    }

    private static ListNode<Integer> sum(ListNode<Integer> l1, ListNode<Integer> l2, int carryOverDigit) {
        if (l1 == null && l2 == null) {
            if (carryOverDigit > 0) {
                return new ListNode<>(carryOverDigit, null);
            }

            return null;
        } else if (l1 == null) {
            int sum = l2.getValue() + carryOverDigit;
            int nextCarryOverDigit = getNextCarryOverDigit(sum);
            ListNode<Integer> nextNode = sum(null, l2.getNext(), nextCarryOverDigit);
            return new ListNode<>(sum % 10, nextNode);
        } else if (l2 == null) {
            int sum = l1.getValue() + carryOverDigit;
            int nextCarryOverDigit = getNextCarryOverDigit(sum);
            ListNode<Integer> next = sum(l1.getNext(), null, nextCarryOverDigit);
            return new ListNode<>(sum % 10, next);
        } else {
            int sum = l1.getValue() + l2.getValue() + carryOverDigit;
            int nextCarryOverDigit = getNextCarryOverDigit(sum);
            ListNode<Integer> next = sum(l1.getNext(), l2.getNext(), nextCarryOverDigit);
            return new ListNode<>(sum % 10, next);
        }
    }

    private static int getNextCarryOverDigit(int value) {
        if (value > 9) {
            return 1;
        }

        return 0;
    }
}
