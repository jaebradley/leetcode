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
    To know if a current node is a duplicate, all we need to know is the next node.
    """
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(val=-1, next=head)
        if head:
            previous_node, current_node = dummy_head, dummy_head.next
            while current_node is not None:
                duplicate_values = False
                while current_node.next is not None and current_node.val == current_node.next.val:
                    current_node = current_node.next
                    duplicate_values = True

                if duplicate_values:
                    previous_node.next = current_node.next
                    current_node = current_node.next
                else:
                    previous_node.next = current_node
                    previous_node = previous_node.next
                    current_node = current_node.next

        return dummy_head.next
