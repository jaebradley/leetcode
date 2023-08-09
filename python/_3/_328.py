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
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy_odd_head = ListNode(val=-1)
        dummy_even_head = ListNode(val=-2)
        current_odd_pointer, current_even_pointer, first_pointer, second_pointer = dummy_odd_head, dummy_even_head, head, None if head is None else head.next

        while first_pointer is not None or second_pointer is not None:
            current_odd_pointer.next = first_pointer
            current_odd_pointer = current_odd_pointer.next

            first_pointer = first_pointer.next
            if first_pointer is not None:
                first_pointer = first_pointer.next

            current_even_pointer.next = second_pointer
            current_even_pointer = current_even_pointer.next

            if second_pointer is not None:
                second_pointer = second_pointer.next

                if second_pointer is not None:
                    second_pointer = second_pointer.next

        combined_list = None
        if dummy_odd_head.next is not None:
            combined_list = dummy_odd_head.next
            current_odd_pointer.next = dummy_even_head.next

        return combined_list
