from collections import deque
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        q = deque([0])
        visited = {0}
        jumps = 0
        nums_count = len(nums)

        while q:
            element_count = len(q)
            for _ in range(element_count):
                current_index = q.popleft()
                if current_index == (nums_count - 1):
                    return jumps

                for step in range(1, 1 + nums[current_index]):
                    next_index = step + current_index
                    if next_index < nums_count and next_index not in visited:
                        visited.add(next_index)
                        q.append(next_index)

            jumps += 1

        raise RuntimeError("should not get here")
