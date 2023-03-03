"""
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
"""

import heapq
from typing import List


class Solution:
    """
    Approach:

    All else equal, choosing the event that finishes first (i.e. has the smaller end day) will never be worse than
    picking another event.

    First, sort all the events by their start day.
    Iterate over these sorted events, prioritizing picking the events that end first.
    Keep track of which events end first by storing the end day in a priority queue.
    Only add events to the priority queue if the event starts before the current day.
    After adding all possible events, pop an event off the heap, increment the event count.
    At this point, we have an event for the current day, so increment the current day.
    Remove the top value of the min heap if the top value indicates an event that ended on a previous day.
    After iterating over all the events, there still might be eligible events to attend on future days.
    Keep going through the heap pop process for eligible days until the heap is exhausted.
    """

    def maxEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda e: e[0])
        min_heap, current_day, event_count, current_event_index = [], 0, 0, 0
        while current_event_index < len(events) or min_heap:
            if not min_heap:
                current_day = events[current_event_index][0]

            while current_event_index < len(events) and events[current_event_index][0] <= current_day:
                heapq.heappush(min_heap, events[current_event_index][1])
                current_event_index += 1

            heapq.heappop(min_heap)
            event_count += 1

            current_day += 1
            while min_heap and min_heap[0] < current_day:
                heapq.heappop(min_heap)

        return event_count
