/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Example 3:
 *
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
const merge = function (intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const mergedIntervals = [];
    let currentMergedInterval = intervals[0];

    for (let i = 1; i < intervals.length; i++) {
        const currentInterval = intervals[i];
        if (currentInterval[0] >= currentMergedInterval[0] && currentInterval[0] <= currentMergedInterval[1]) {
            currentMergedInterval[1] = Math.max(currentMergedInterval[1], currentInterval[1]);
        } else {
            mergedIntervals.push(currentMergedInterval);
            currentMergedInterval = currentInterval;
        }
    }

    mergedIntervals.push(currentMergedInterval)

    return mergedIntervals;
};

export default merge;