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
    """
    To reverse singly linked list, use a stack.
    Add nodes starting from "left" index to "right" index to stack.
    Keep track of node "before" left index node and node "after" right index node.
    Have the "before" node's "next" value point to the top of the stack.
    Once the last value in the stack is popped, point it's "next" value to the "after" node.
    """

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == right:
            return head

        dummyNode = ListNode(0)
        dummyNode.next = head
        pre = dummyNode

        for i in range(left - 1):
            pre = pre.next

        # reverse the [left, right] nodes
        reverse = None
        cur = pre.next
        for i in range(right - left + 1):
            next = cur.next
            cur.next = reverse
            reverse = cur
            cur = next

        pre.next.next = cur
        pre.next = reverse

        return dummyNode.next
