package problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/insert-interval/
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Example 3:
 * <p>
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * Example 4:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * Example 5:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals is sorted by intervals[i][0] in ascending order.
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * Approach:
 *
 * 1. Iterate over all intervals that start before the interval to insert, add it to the results
 * 2. Once reach interval that is overlapping interval to insert, combine / merge intervals together until merged interval does not
 * overlap with next interval (continue iterating over intervals)
 * 3. Iterate over all intervals that are left (i.e are not mergeable) and add them to the result set
 */

public class InsertInterval {
    private static class Interval {
        private final int start;
        private final int end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(final Interval interval) {
            return (interval.start <= start && interval.end >= start) ||
                    (interval.start >= start && interval.start <= end);
        }

        public static Interval merge(final Interval first, final Interval second) {
            return new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        final Interval insert = new Interval(newInterval[0], newInterval[1]);
        final List<Interval> results = new ArrayList<>();

        int index = 0;

        while (index < intervals.length && intervals[index][1] < insert.start) {
            results.add(new Interval(intervals[index][0], intervals[index][1]));
            index++;
        }

        Interval mergedInterval = insert;
        while (index < intervals.length && new Interval(intervals[index][0], intervals[index][1]).overlaps(mergedInterval)) {
            mergedInterval = Interval.merge(mergedInterval, new Interval(intervals[index][0], intervals[index][1]));
            index++;
        }

        results.add(mergedInterval);

        while (index < intervals.length) {
            results.add(new Interval(intervals[index][0], intervals[index][1]));
            index++;
        }

        return results
                .stream()
                .map(
                        v -> new int[]{v.start, v.end}
                ).toArray(int[][]::new);
    }
}
