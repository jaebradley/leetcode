package problems;

import data.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists, and it should be ordered.
 */

public class LinkedListsMerger {
    public static ListNode<Integer> merge(ListNode<Integer> firstList, ListNode<Integer> secondList) {
        if (firstList == null && secondList == null) {
            return null;
        }

        if (firstList == null) {
            return secondList;
        }

        if (secondList == null) {
            return firstList;
        }

        if (firstList.getValue() < secondList.getValue()) {
            return new ListNode<>(firstList.getValue(), merge(firstList.getNext(), secondList));
        }

        return new ListNode<>(secondList.getValue(), merge(firstList, secondList.getNext()));
    }
}
