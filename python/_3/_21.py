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
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        current_node = head
        current_list_1_node = list1
        current_list_2_node = list2

        while current_list_1_node and current_list_2_node:
            if current_list_1_node.val > current_list_2_node.val:
                current_node.next = current_list_2_node
                current_list_2_node = current_list_2_node.next
            else:
                current_node.next = current_list_1_node
                current_list_1_node = current_list_1_node.next
            current_node = current_node.next

        if current_list_1_node:
            current_node.next = current_list_1_node
        elif current_list_2_node:
            current_node.next = current_list_2_node

        return head.next