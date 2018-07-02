package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * * algorithms
 * * Medium (32.31%)
 * * Total Accepted:    211.3K
 * * Total Submissions: 651.3K
 * * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

/**
 * 1. Build a graph of each interval linked to a list of all overlapping intervals.
 *    This is represented as a Map of Intervals to Lists of Intervals.
 * 2. Build a map of connected components - these are components that can be tied to one another via another component.
 *    For example, a component that overlaps with another component and the merging of these two components overlaps
 *    with a third component. This map is built by iterating through the graph of intervals using DFS. When the end of
 *    a connected component is reached, the connected component index is incremented.
 * 3. These connected components are then merged by using the minimum start and maximum end values to create the new
 *    "merged" intervals.
 */

public class MergeIntervals {
    private Map<Interval, List<Interval>> graph = new HashMap<>();
    private Map<Integer, List<Interval>> connectedNodes = new HashMap<>();
    private Set<Interval> visitedIntervals = new HashSet<>();

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.start, this.end);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return Objects.equals(start, interval.start)
                    && Objects.equals(end, interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        int connectedNodeNumber = 0;
        visitedIntervals = new HashSet<>();
        connectedNodes = new HashMap<>();
        createGraph(intervals);

        for (Interval interval : intervals) {
            if (!visitedIntervals.contains(interval)) {
                dfs(interval, connectedNodeNumber);
                connectedNodeNumber++;
            }
        }

        List<Interval> merged = new ArrayList<>();
        for (List<Interval> connectedIntervals : connectedNodes.values()) {
            merged.add(mergeIntervals(connectedIntervals));
        }
        return merged;
    }

    private static boolean overlap(Interval firstInterval, Interval secondInterval) {
        return firstInterval.start <= secondInterval.end && secondInterval.start <= firstInterval.end;
    }

    private void createGraph(List<Interval> intervals) {
        for (Interval firstInterval : intervals) {
            for (Interval secondInterval : intervals) {
                List<Interval> overlappingIntervals = graph.get(firstInterval);
                if (overlappingIntervals == null) {
                    graph.put(firstInterval, new LinkedList<>());
                } else if (overlap(firstInterval, secondInterval)) {
                    overlappingIntervals.add(secondInterval);
                    graph.put(firstInterval, overlappingIntervals);
                }
            }
        }
    }

    private static Interval mergeIntervals(List<Interval> intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start < min) {
                min = interval.start;
            }

            if (interval.end > max) {
                max = interval.end;
            }
        }

        return new Interval(min, max);
    }

    private void dfs(Interval interval, int connectedComponentNumber) {
        Stack<Interval> intervals = new Stack<>();
        intervals.add(interval);

        while (!intervals.isEmpty()) {
            Interval currentInterval = intervals.pop();
            if (!visitedIntervals.contains(currentInterval)) {
                visitedIntervals.add(currentInterval);

                List<Interval> connectedComponents = connectedNodes.get(connectedComponentNumber);
                if (connectedComponents == null) {
                    connectedComponents = new LinkedList<>();
                }

                connectedComponents.add(currentInterval);
                connectedNodes.put(connectedComponentNumber, connectedComponents);
                intervals.addAll(graph.get(currentInterval));
            }
        }
    }
}
