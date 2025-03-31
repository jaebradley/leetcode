# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __eq__(self, other):
        """Overrides the default implementation"""
        if isinstance(other, ListNode):
            return self.val == other.val and self.next == other.next
        return False


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # find middle of list
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        # reverse list
        previous_node = None
        while slow:
            next_slow = slow.next
            slow.next = previous_node
            previous_node = slow
            slow = next_slow

        # merge both lists, specifically the start of the original list, with the reversed list (from the last element to the middle element)
        first, second = head, previous_node
        while second and second.next:
            next_first = first.next
            next_second = second.next

            first.next = second
            first = next_first

            second.next = first
            second = next_second

        return head
