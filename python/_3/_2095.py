from typing import Optional


# Definition for singly-linked list.
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
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(val=-1, next=head)
        before_first_pointer = None
        first_pointer = dummy_head
        after_first_pointer = first_pointer.next
        second_pointer = dummy_head

        while second_pointer is not None:
            before_first_pointer = first_pointer
            first_pointer = first_pointer.next
            if first_pointer is None:
                after_first_pointer = None
            else:
                after_first_pointer = first_pointer.next
            second_pointer = second_pointer.next
            if second_pointer is not None:
                second_pointer = second_pointer.next

        if before_first_pointer is not None:
            before_first_pointer.next = after_first_pointer

        return dummy_head.next
