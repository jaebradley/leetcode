from typing import List

"""
You are given an integer eventTime denoting the duration of an event. 
You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 
and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the 
meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.
"""


class Solution:
    """
    Like previous problem (3439) but k = 1 AND the relative ordering can change.
    'What's the largest free space separated by one or zero blocks where the blocks can be moved?'
    'Find the farthest open slot to the left or right with that size'
    Calculate gaps
    Calculate largest gaps traversing from right to left.
    Starting from left to right, keep track of largest gaps (from left to right).
    While iterating, keep track of the current event
    If the current event length can fit into the largest left or right gap seen by that index, then the result is the
    length of the immediate left gap plus length of the immediate right gap plus the length of the current event's
    length.
    If the current event can't fit into a left or right gap sum the immediate left and right gaps.
    """
    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        gaps = [0] * (1 + len(startTime))
        gaps[0] = startTime[0]
        gaps[-1] = eventTime - endTime[-1]
        for i in range(1, len(startTime)):
            gaps[i] = startTime[i] - endTime[i - 1]

        largest_right = [0] * len(gaps)
        for current_gap_index in range(len(gaps) - 2, -1, -1):
            largest_right[current_gap_index] = max(largest_right[current_gap_index + 1], gaps[current_gap_index + 1])

        largest_left = 0
        result = 0
        for current_gap_index in range(1, len(gaps)):
            current_event_length = endTime[current_gap_index - 1] - startTime[current_gap_index - 1]
            if current_event_length <= max(largest_left, largest_right[current_gap_index]):
                result = max(result, gaps[current_gap_index - 1] + gaps[current_gap_index] + current_event_length)
            result = max(result, gaps[current_gap_index - 1] + gaps[current_gap_index])
            largest_left = max(largest_left, gaps[current_gap_index - 1])

        return result