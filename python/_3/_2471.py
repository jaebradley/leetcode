"""
https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
"""
from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        q = []
        if root:
            q.append(root)

        operations = 0
        while 0 < len(q):
            current_level_size = len(q)
            operations += self.calculate_level_operations(list(q))
            for _ in range(current_level_size):
                current_node = q.pop(0)
                if current_node.left:
                    q.append(current_node.left)

                if current_node.right:
                    q.append(current_node.right)

        return operations

    def calculate_level_operations(self, nodes: List[TreeNode]):
        swap_count = 0
        node_count = len(nodes)

        for starting_index in range(0, node_count):
            current_node = nodes[starting_index]

            swap_index = starting_index
            for next_node_index in range(starting_index + 1, node_count):
                if nodes[next_node_index].val < current_node.val:
                    swap_index += 1

            if swap_index != starting_index:
                nodes[swap_index], current_node = current_node, nodes[swap_index]
                swap_count += 1

                while swap_index != starting_index:
                    swap_index = starting_index
                    for next_node_index in range(starting_index + 1, node_count):
                        if nodes[next_node_index].val < current_node.val:
                            swap_index += 1

                    if swap_index != starting_index:
                        nodes[swap_index], current_node = current_node, nodes[swap_index]
                        swap_count += 1

        return swap_count
