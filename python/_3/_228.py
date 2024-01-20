from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ranges = []
        if nums:
            current_range_start = 0

            for current_index in range(1, len(nums)):
                previous_index = current_index - 1
                previous_number = nums[previous_index]
                current_number = nums[current_index]
                if current_number != previous_number + 1:
                    if current_range_start == previous_index:
                        serialized_range = str(previous_number)
                    else:
                        serialized_range = "->".join([str(nums[current_range_start]), str(previous_number)])

                    ranges.append(serialized_range)
                    current_range_start = current_index

            previous_index = len(nums) - 1
            previous_number = nums[previous_index]
            if current_range_start == previous_index:
                serialized_range = str(previous_number)
            else:
                serialized_range = "->".join([str(nums[current_range_start]), str(previous_number)])

            ranges.append(serialized_range)

        return ranges
