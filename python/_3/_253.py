"""
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.


Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
"""
import heapq
from typing import List


class Solution:
    """
    Sort by start time.
    Minimum number of conference rooms required = maximum of number of concurrent meetings at any given start time.
    Iterate over sorted intervals.
    Keep track of interval end times.
    For each processed interval, increment the active interval count.
    Decrement intervals that end before current start time. (How to optimize this, heap?)
    minimum number = max(previous min, active interval count)

    Runtime analysis:
    Sorting = O(n log n)
    Heap = O(n log n)
    Total = O(n log n) + O(n log n) => O(n log n)
    """

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        minimum_rooms, active_meetings, sorted_end_times = 0, 0, []
        intervals.sort(key=lambda x: x[0])

        for start, end in intervals:
            active_meetings += 1
            while sorted_end_times and sorted_end_times[0] <= start:
                heapq.heappop(sorted_end_times)
                active_meetings -= 1
            heapq.heappush(sorted_end_times, end)
            minimum_rooms = max(minimum_rooms, active_meetings)

        return minimum_rooms
