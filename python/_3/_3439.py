from collections import deque
from typing import List

"""
You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time 
t = eventTime.

You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of 
n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the 
longest continuous period of free time during the event.

The relative order of all the meetings should stay the same and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event.
"""


class Solution:
    """
    Sliding window of size K + 1 gaps (since can move all K meetings to start of sequence to get max free time).
    Keep max length as the window slides.
    Need to move left edge of window if a K + 2nd gap is seen or until max event time is reached.
    """

    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        gaps = [0] * (1 + len(startTime))
        gaps[0] = startTime[0]
        gaps[-1] = eventTime - endTime[-1]
        for i in range(1, len(startTime)):
            gaps[i] = startTime[i] - endTime[i - 1]

        current_sum = sum(gaps[:k + 1])
        max_length = current_sum
        for gap_index in range(k + 1, len(gaps)):
            current_sum += gaps[gap_index] - gaps[gap_index - k - 1]
            max_length = max(max_length, current_sum)

        return max_length
