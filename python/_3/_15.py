from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        seen, processed_nums, results = {}, set(), set()
        for left_index in range(len(nums) - 1):
            left = nums[left_index]
            if left not in processed_nums:
                processed_nums.add(left)

                for right_index in range(left_index + 1, len(nums)):
                    right = nums[right_index]
                    complement = -(left + right)
                    if complement in seen and seen[complement] == left_index:
                        results.add(tuple(sorted((left, right, complement))))
                    seen[right] = left_index

        return list(map(lambda v: list(v), results))
