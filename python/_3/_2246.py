"""
https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
"""

from typing import List


class Solution:

    def __init__(self):
        self.max_value = 0

    """
    For a given node, the longest path with different adjacent characters that goes through that node is the sum of the
    two longest child paths (since this is an n-ary tree).

    If a child has the same character as the root, iterate over it (because it might contain the longest path) but its
    path length relative to its parent is 0.
    
    Return to the current node's parent it's longest path + 1. This value represents the longest path along the sub-tree 
    containing the current node (relative to the parent).
    """

    def longestPath(self, parent: List[int], s: str) -> int:
        adjacency_list = {}
        for index, parent_node in enumerate(parent):
            if index > 0:
                children = adjacency_list.get(parent_node, set([]))
                children.add(index)
                adjacency_list[parent_node] = children

        self.dfs(current_node=0, adjacency_list=adjacency_list, values=s)

        return self.max_value

    def dfs(self, current_node, adjacency_list, values) -> int:
        if current_node is None:
            return 0

        longest_path = 0
        second_longest_path = 0
        for child in adjacency_list.get(current_node, set([])):
            longest_child_path = self.dfs(child, adjacency_list, values)
            if values[child] != values[current_node]:
                if longest_child_path > longest_path:
                    second_longest_path = longest_path
                    longest_path = longest_child_path
                elif longest_child_path > second_longest_path:
                    second_longest_path = longest_child_path

        self.max_value = max(self.max_value, sum([1, longest_path, second_longest_path]))

        return 1 + longest_path
