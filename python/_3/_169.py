from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        first, first_count = None, 0

        index = 0
        while index < len(nums):
            num = nums[index]
            if num == first:
                first_count += 1
            elif first is None:
                first = num
                first_count += 1
            else:
                first_count -= 1

                if 0 == first_count:
                    first = None

            index += 1

        return first
