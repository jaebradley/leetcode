package problems;

import data.ListNode;

/**
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
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
