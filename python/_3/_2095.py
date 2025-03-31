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
        dummy = ListNode(val=0, next=head)
        before, slow, fast = dummy, head, head
        while fast and fast.next:
            before = slow
            slow = slow.next
            fast = fast.next.next

        before.next = slow.next

        return dummy.next
