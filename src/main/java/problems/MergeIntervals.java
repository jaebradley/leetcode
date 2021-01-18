package problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * Approach:
 * <p>
 * 1. Interval is overlapping if there is an interval that has a start which is greater than or equal to another interval's start and less than or equal to another interval's end
 * 2. Sort intervals by their start index
 * 3. Pick the first interval and if next interval overlaps, update the current interval under consideration to start
 * with minimum of start value and maximum of end values
 * 4. Continue evaluating intervals until an interval does not overlap
 * 5. Add the current interval to the array of array of intervals and set the non-overlapping interval as the current interval
 * 6. Continue this process until all intervals have been evaluated
 */

public class MergeIntervals {
    private static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Interval merge(final Interval interval1, final Interval interval2) {
            return new Interval(Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
        }

        public boolean overlaps(final Interval other) {
            return start <= other.start && end >= other.start;
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

    public int[][] merge(int[][] intervals) {
        final List<Interval> results = new ArrayList<>();
        final Deque<Interval> sortedIntervals = Arrays.stream(intervals).sorted(
                Comparator.comparingInt(o -> o[0])
        )
                .map(v -> new Interval(v[0], v[1]))
                .collect(Collectors.toCollection(LinkedList::new));

        while (sortedIntervals.size() > 1) {
            final Interval currentInterval = sortedIntervals.poll();
            final Interval nextInterval = sortedIntervals.poll();

            if (currentInterval.overlaps(nextInterval)) {
                sortedIntervals.addFirst(Interval.merge(currentInterval, nextInterval));
            } else {
                sortedIntervals.addFirst(nextInterval);
                results.add(currentInterval);
            }
        }

        if (sortedIntervals.size() == 1) {
            results.add(sortedIntervals.poll());
        }

        return results
                .stream()
                .map(
                        v -> new int[]{v.start, v.end}
                )
                .toArray(int[][]::new);
    }
}
