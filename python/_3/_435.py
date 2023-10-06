from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if 0 == len(intervals):
            return 0

        intervals.sort(key=lambda interval: interval[1])
        current_ending_value = intervals[0][1]
        non_overlapping_interval_count = 1

        for interval_index in range(1, len(intervals)):
            interval = intervals[interval_index]
            if interval[0] >= current_ending_value:
                non_overlapping_interval_count += 1
                current_ending_value = interval[1]

        return len(intervals) - non_overlapping_interval_count
