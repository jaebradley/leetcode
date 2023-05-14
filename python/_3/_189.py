"""
https://leetcode.com/problems/rotate-array/description/
"""

from typing import List, Set


class Solution:
    """
    k % length of nums = # of places to move

    nums[0] -> nums[x]
    nums[1] -> nums[1 + x]

    initial index + x % length of nums = next index
    """

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        offset = k % len(nums)
        visited = set([])
        for index in range(0, len(nums)):
            current_value = nums[index]
            next_index = (index + offset) % len(nums)
            self.dfs(next_index, current_value, offset, nums, visited)

    def dfs(self, current_index: int, next_value: int, offset: int, nums: List[int], visited: Set[int]):
        if current_index not in visited:
            visited.add(current_index)

            current_value = nums[current_index]
            next_index = (current_index + offset) % len(nums)

            self.dfs(next_index, current_value, offset, nums, visited)

            nums[current_index] = next_value
