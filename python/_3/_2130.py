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
    def pairSum(self, head: Optional[ListNode]) -> int:
        dummy_head = ListNode(val=-1, next=head)
        first_pointer, second_pointer = dummy_head, head
        stack = []

        while first_pointer is not None and second_pointer is not None:
            first_pointer = first_pointer.next
            stack.append(first_pointer.val)

            second_pointer = second_pointer.next
            if second_pointer is not None:
                second_pointer = second_pointer.next

        max_pair_sum = float("-inf")

        first_pointer = first_pointer.next

        while first_pointer is not None and 0 < len(stack):
            max_pair_sum = max(stack.pop() + first_pointer.val, max_pair_sum)
            first_pointer = first_pointer.next

        return max_pair_sum
