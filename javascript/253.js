import {MinHeap} from '@datastructures-js/heap';

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of
 * conference rooms required.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */

/**
 * Approach:
 * Maximum number of concurrent meetings.
 * Two meetings are concurrent when
 * 1. Meeting 2's start time >= Meeting 1's start time AND
 * 2. Meeting 2's end time >= Meeting 1's end time
 * Order by start time.
 * Use a min heap to keep track of interval end times.
 * When evaluating the next meeting, pop off any previously overlapping intervals that will no longer overlap.
 * These intervals have an end time that are before the next interval's start time.
 * Since the intervals are sorted by start time, these intervals will be invalid for all future intervals as well.
 * The max number of concurrent meetings is the max of the heap's size.
 * Runtime: O(# of intervals x log(# of intervals))
 * Sorting takes O(# of intervals x log(# of intervals)) and then adding elements to the heap, in the worst case, would
 * be O(# of intervals x log(# of intervals)).
 * Space: O(# of intervals)
 * @param {number[][]} intervals
 * @return {number}
 */
const minMeetingRooms = function (intervals) {
    const minimumEndingTime = new MinHeap();

    // Sort the interval in descending order so that popping off the array is O(1)
    intervals.sort((firstMeeting, secondMeeting) => secondMeeting[0] - firstMeeting[0]);

    minimumEndingTime.push(intervals.pop()[1]);
    let maximumOverlappingMeetings = Number.MIN_SAFE_INTEGER;

    while (!minimumEndingTime.isEmpty()) {
        maximumOverlappingMeetings = Math.max(minimumEndingTime.size(), maximumOverlappingMeetings);
        const interval = intervals.pop();
        if (interval) {
            let currentEndingTime = minimumEndingTime.top();
            while (!!currentEndingTime && currentEndingTime <= interval[0]) {
                minimumEndingTime.pop();
                currentEndingTime = minimumEndingTime.top();
            }
            minimumEndingTime.push(interval[1]);
        } else {
            break;
        }
    }

    return maximumOverlappingMeetings;
};

export default minMeetingRooms;

