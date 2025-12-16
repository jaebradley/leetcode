"""
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
"""


# Definition for a Node.
class Node:
    def __init__(self, val: int, next: 'Node' = None, random: 'Node' = None):
        self.val = val
        self.next = next
        self.random = random


class Solution:
    """
    Weave the copied list nodes with the existing list nodes.
    A -> B -> C becomes A -> A' -> B -> B' -> C -> C'.
    This means that the random node copy is the node AFTER the actual random node.
    At the end, need to disentangle existing list from copied list.
    """

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        current_node = head
        while current_node:
            copied_node = Node(val=current_node.val, next=current_node.next)
            current_node.next = copied_node
            current_node = copied_node.next

        current_node = head
        while current_node:
            if current_node.random:
                current_node.next.random = current_node.random.next

            current_node = current_node.next.next

        original_node, copied_head, copied_node = head, head.next, head.next
        while original_node:
            original_node.next = original_node.next.next
            if copied_node.next:
                copied_node.next = copied_node.next.next
            original_node = original_node.next
            copied_node = copied_node.next

        return copied_head


class RecursiveSolution:
    """
    Memoize whether a previous node has been seen in a dict.
    Recursively call the same helper function for the node's next and random pointers.
    In the case of a cycle (a node referencing a previous node), the node will have already been seen, so the reference
    to the already been seen node instance will be used.
    That node instance will also be updated.
    """
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copied_nodes_by_seen_nodes = {}

        def helper(node):
            if node:
                if node not in copied_nodes_by_seen_nodes:
                    copied_nodes_by_seen_nodes[node] = Node(node.val)

                    copied_node = copied_nodes_by_seen_nodes[node]
                    copied_node.next = helper(node.next)
                    copied_node.random = helper(node.random)

                return copied_nodes_by_seen_nodes[node]
            return None

        return helper(head)
