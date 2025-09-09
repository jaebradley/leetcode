from typing import List

"""
Given an array of `intervals` where intervals[i] = [starti, endi]`, merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.
"""

class Solution:
    """
    Order by start value.
    Keep track of a merged interval.
    When a current interval does not intersect with the merged interval, then the merged interval is added to the result
    list and the current interval is the new merged interval.
    """
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        def intersects(first_interval, second_interval) -> bool:
            return second_interval[0] <= first_interval[1]

        intervals_ordered_by_starting_value = sorted(intervals, key=lambda interval: interval[0])
        results, merged_interval, current_index = [], intervals_ordered_by_starting_value[0], 1
        while current_index < len(intervals_ordered_by_starting_value):
            current_interval = intervals_ordered_by_starting_value[current_index]
            if intersects(merged_interval, current_interval):
                merged_interval = [min(current_interval[0], merged_interval[0]), max(current_interval[1], merged_interval[1])]
            else:
                results.append(merged_interval)
                merged_interval = current_interval
            current_index += 1

        results.append(merged_interval)

        return results