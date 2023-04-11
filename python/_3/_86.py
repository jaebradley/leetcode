"""
https://leetcode.com/problems/partition-list/
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
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        second_list_head = ListNode()
        second_list = second_list_head
        dummy_head = ListNode(val=float("-inf"), next=head)
        previous_node = dummy_head

        while previous_node is not None:
            current_node = previous_node.next

            if current_node is not None:
                if current_node.val >= x:
                    previous_node.next = current_node.next
                    current_node.next = None
                    second_list.next = current_node
                    second_list = second_list.next
                else:
                    previous_node = current_node
            else:
                previous_node.next = second_list_head.next
                break

        return dummy_head.next
