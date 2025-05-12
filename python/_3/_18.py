from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:

        def kSum(nums: List[int], target: int, k: int) -> List[List[int]]:
            result = []

            # If we have run out of numbers to add, return result.
            if not nums:
                return result

            # There are k remaining values to add to the sum. The
            # average of these values is at least target // k.
            average_value = target // k

            # We cannot obtain a sum of target if the smallest value
            # in nums is greater than target // k or if the largest
            # value in nums is smaller than target // k.
            if average_value < nums[0] or nums[-1] < average_value:
                return result

            if k == 2:
                return twoSum(nums, target)

            for current_index in range(len(nums)):
                # If current value is first number or if previous number is not equal to current number
                if current_index == 0 or nums[current_index - 1] != nums[current_index]:
                    # iterate over sums returned for decremented group size and decremented target value using remaining
                    # numbers
                    for subset in kSum(nums[current_index + 1:], target - nums[current_index], k - 1):
                        result.append([nums[current_index]] + subset)

            return result

        def twoSum(nums: List[int], target: int) -> List[List[int]]:
            result = []
            left_index, right_index = 0, len(nums) - 1

            while left_index < right_index:
                current_sum = nums[left_index] + nums[right_index]
                # includes previous value check
                if current_sum < target or (left_index > 0 and nums[left_index] == nums[left_index - 1]):
                    left_index += 1
                # includes previous value check
                elif current_sum > target or (
                        right_index < len(nums) - 1 and nums[right_index] == nums[right_index + 1]
                ):
                    right_index -= 1
                else:
                    result.append([nums[left_index], nums[right_index]])
                    left_index += 1
                    right_index -= 1

            return result

        nums.sort()
        return kSum(nums, target, 4)
