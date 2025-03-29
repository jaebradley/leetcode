from typing import List


class Solution:
    """
    Iterate over the numbers.
    If a number has already been seen, then don't consider it.
    Else start iterating over all numbers to the right of this number.
    For each of these "right" numbers, calculate the sum of the current number and the number to the right.
    The negative of this sum is the "complement" and the third value we're looking for to make a valid "three sum".
    If the complement has already been seen, and using the current number's index to kind've track when the complement's was seen,
    if the complement was seen in this current loop (i.e. matching the current number's index), then add
    the valid three sum (sorted, to avoid duplicates).
    Overwrite the current number's index for the "right" number value in the "seen" mapping. This is so that any future
    value, where the complement given the current value and the right value at that time, matches the current right value,
    will again be "caught" as a valid three sum.
    """

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
