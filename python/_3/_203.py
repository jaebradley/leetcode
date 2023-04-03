"""
https://leetcode.com/problems/remove-linked-list-elements/description/
"""

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
    Approach:

    Previous node (initially set to a "dummy" node)
    Current node (initially set to head)
    Next node (head.next)
    If the current node has the same value, connect the previous node and the next node
    Set the current node as the next node
    Do this until the current node is none
    Return the dummy node.next value
    """

    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        # Problem states that node value are positive
        starting_node = ListNode(val=-1, next=head)
        previous_node = starting_node
        current_node = head
        while current_node is not None:
            next_node = current_node.next
            if current_node.val == val:
                previous_node.next = next_node
            else:
                previous_node = current_node
            current_node = next_node

        return starting_node.next
