from typing import List


class Solution:
    """
    3 sum works by iterating over list, and then calling 2 sum for each element.
    2 sum works by either iterating the lower or higher element depending on if the target sum is satisfied.
    I think you want to call 3 sum for each element in this list
    """

    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        sorted_nums = sorted(nums)
        previous_value, result = None, []
        for current_index in range(len(sorted_nums)):
            current_value = sorted_nums[current_index]
            if current_value != previous_value:
                for triplets in self.threeSum(sorted_nums=sorted_nums, target=target - current_value,
                                              starting_index=1 + current_index):
                    result.append([current_value] + triplets)

            previous_value = current_value

        return result

    def threeSum(self, sorted_nums, target, starting_index) -> List[List[int]]:
        result, nums_count = [], len(sorted_nums)

        def find_triples(lowest_inclusive_index, highest_inclusive_index, smallest_value, values, results):
            while lowest_inclusive_index < highest_inclusive_index:
                total = smallest_value + values[highest_inclusive_index] + values[lowest_inclusive_index]
                if total < target:
                    lowest_inclusive_index += 1
                elif total > target:
                    highest_inclusive_index -= 1
                else:
                    results.append([smallest_value, values[lowest_inclusive_index], values[highest_inclusive_index]])
                    # decrement highest, because it's guaranteed (since the values are ordered) that the next
                    # unique lower number will be greater than the current lower number, which will be a greater
                    # sum than the current target
                    highest_inclusive_index -= 1
                    lowest_inclusive_index += 1
                    while lowest_inclusive_index < highest_inclusive_index and values[lowest_inclusive_index] == values[
                        lowest_inclusive_index - 1]:
                        lowest_inclusive_index += 1

        previous_value = None if starting_index <= 0 else sorted_nums[starting_index - 1]
        for current_index in range(starting_index, nums_count):
            current_value = sorted_nums[current_index]
            if current_value > target:
                break
            if current_value != previous_value:
                find_triples(1 + current_index, nums_count - 1, current_value, sorted_nums, result)

            previous_value = current_value

        return result
