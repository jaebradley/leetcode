from typing import List


class Solution:
    """
    start > end (unless rotated 0 or n times)
    Find middle
    If middle > start, then from start to middle is in sorted order
    If middle < end, then middle to end is in sorted order
    If both of these conditions are true, smallest is somewhere between index 0 and start's index
    If middle < start, then minimum is beween middle and start
    If middle > end, then minimum is between middle and end

    """
    def findMin(self, nums: List[int]) -> int:
        def find(start_index, end_index, nums):
            if start_index >= end_index:
                return nums[end_index]

            start_value, end_value, middle_index = nums[start_index], nums[end_index], (start_index + end_index) // 2
            middle_value = nums[middle_index]
            if middle_value < start_value:
                return find(1 + start_index, middle_index, nums)

            if middle_value > end_value:
                return find(1 + middle_index, end_index, nums)

            return find(0, start_index, nums)

        return find(0, len(nums) - 1, nums)