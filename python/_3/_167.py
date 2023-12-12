from typing import List


class Solution:
    """
    For left index, all numbers to the right are greater than or equal to that value.
    For right index, all numbers to the left are less than or equal to that value.

    Start with first index and last index.
    If sum == target, then finished.
    If sum < target, increment first index and re-evaluate.
    If sum > target, decrement last index and re-evaluate.

    Do this while the left index < the right index.
    There should be a solution.
    """

    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left_index, right_index = 0, len(numbers) - 1

        while left_index < right_index:
            current_sum = numbers[left_index] + numbers[right_index]
            if current_sum == target:
                return [left_index + 1, right_index + 1]
            elif current_sum < target:
                left_index += 1
            else:
                right_index -= 1

        raise ValueError("should never get here")
