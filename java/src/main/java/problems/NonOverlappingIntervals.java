package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 *
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 *
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 * Approach:
 *
 * 1. Another way of thinking about the problem is finding the maximum number of non-overlapping intervals
 * 2. Start by sorting the intervals by the end index
 * 3. Iterate from the first interval onwards - if the next interval's start is gte the current end, it is not overlapping
 * 4. If it's not overlapping, update the current end to tbe the next interval's end
 * 5. If it is overlapping, update the counter of overlapping intervals
 *
 */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        final AtomicInteger currentEndIndex = new AtomicInteger(Integer.MIN_VALUE);
        final AtomicInteger countOfOverlappingIntervals = new AtomicInteger(0);
        Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(ints -> ints[1]))
                .forEach(
                        v -> {
                            if (v[0] >= currentEndIndex.get()) {
                                currentEndIndex.set(v[1]);
                            } else {
                                countOfOverlappingIntervals.getAndIncrement();
                            }
                        }
                );
        return countOfOverlappingIntervals.get();
    }
}
