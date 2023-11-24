from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        current_maximum_jump = 0
        for index, step in enumerate(nums):
            if index > current_maximum_jump:
                return False
            current_maximum_jump = max(current_maximum_jump, index + step)
        return True
