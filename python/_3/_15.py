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


class TwoPointerSolution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sorted_nums = sorted(nums)
        result = []
        def find_triples(lowest_inclusive_index, highest_inclusive_index, target,  values, results):
            while lowest_inclusive_index < highest_inclusive_index:
                total = target + values[highest_inclusive_index] + values[lowest_inclusive_index]
                if total < 0:
                    lowest_inclusive_index += 1
                elif total > 0:
                    highest_inclusive_index -= 1
                else:
                    results.append([current_value, values[lowest_inclusive_index], values[highest_inclusive_index]])
                    # decrement highest, because it's guaranteed (since the values are ordered) that the next
                    # unique lower number will be greater than the current lower number, which will be a greater
                    # sum than the current target
                    highest_inclusive_index -= 1
                    lowest_inclusive_index += 1
                    while lowest_inclusive_index < highest_inclusive_index and values[lowest_inclusive_index] == values[lowest_inclusive_index - 1]:
                        lowest_inclusive_index += 1

        previous_value = None
        for current_index in range(len(sorted_nums)):
            current_value = sorted_nums[current_index]
            if current_value > 0:
                break

            if current_value != previous_value:
                find_triples(1 + current_index, len(nums) - 1, current_value, sorted_nums, result)

            previous_value = current_value

        return result
