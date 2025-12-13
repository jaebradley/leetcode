"""
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
"""
from typing import List


class Solution:
    """
    Sort intervals by starting time.
    If the next interval before the current interval end time, then return false.
    Else return true.
    Sorting has a runtime of O(n x log n).
    """

    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        sorted_by_start_time_ascending = sorted(intervals, key=lambda x: x[0])
        for i in range(len(sorted_by_start_time_ascending) - 1):
            if sorted_by_start_time_ascending[i][1] > sorted_by_start_time_ascending[i + 1][0]:
                return False

        return True
