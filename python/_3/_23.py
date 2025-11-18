"""
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
"""
from typing import List, Optional
from heapq import heapify, heappush, heappop

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
    class HeapNode(ListNode):
        def __init__(self, val=0, next=None):
            super().__init__(val, next)

        def __lt__(self, other):
            return self.val < other.val

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        values = [Solution.HeapNode(val=head.val, next=head.next) for head in lists if head]
        heapify(values)
        head = ListNode()
        previous_node = head

        while values:
            smallest_value = heappop(values)
            previous_node.next = ListNode(val=smallest_value.val)
            previous_node = previous_node.next
            if smallest_value.next:
                heappush(values, Solution.HeapNode(val=smallest_value.next.val, next=smallest_value.next.next))

        return head.next
