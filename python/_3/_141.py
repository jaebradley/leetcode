from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        fast, slow = head, head
        while fast is not None:
            for _ in range(2):
                if fast:
                    fast = fast.next
                    if fast == slow:
                        return True

            slow = slow.next

        return False