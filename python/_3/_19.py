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
    If head is not present, return none.


    """

    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(val=0, next=head)
        nodes = []
        current_node = dummy
        while current_node is not None:
            nodes.append(current_node)
            current_node = current_node.next

        starting_index, previous_node, next_node = len(nodes) - 1, nodes[len(nodes) - 2], None
        while starting_index > 0 and (len(nodes) - starting_index) != n:
            starting_index -= 1

            previous_node = nodes[starting_index - 1]
            next_node = nodes[starting_index + 1]

        previous_node.next = next_node

        return dummy.next
