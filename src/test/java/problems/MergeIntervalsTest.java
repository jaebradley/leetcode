package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static problems.MergeIntervals.*;

public class MergeIntervalsTest {
    private final MergeIntervals merger = new MergeIntervals();

    @Test
    public void doesNotMergeTwoNonOverlappingIntervals() {
        Interval firstInterval = new Interval(1, 2);
        Interval secondInterval = new Interval(3, 4);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(firstInterval);
        intervals.add(secondInterval);
        List<Interval> expected = new ArrayList<>();
        expected.add(firstInterval);
        expected.add(secondInterval);
        assertEquals(merger.merge(intervals), expected);
    }

    @Test
    public void doesMergeTwoOverlappingIntervals() {
        Interval firstInterval = new Interval(1, 2);
        Interval secondInterval = new Interval(2, 4);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(firstInterval);
        intervals.add(secondInterval);
        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 4));
        assertEquals(merger.merge(intervals), expected);
    }

    @Test
    public void mergeConnectedComponents() {
        Interval firstInterval = new Interval(1, 2);
        Interval secondInterval = new Interval(2, 4);
        Interval thirdInterval = new Interval(3, 5);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(firstInterval);
        intervals.add(secondInterval);
        intervals.add(thirdInterval);
        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 5));
        assertEquals(merger.merge(intervals), expected);
    }

    @Test
    public void mergeTwoDifferentConnectedComponents() {
        Interval firstInterval = new Interval(1, 2);
        Interval secondInterval = new Interval(2, 4);
        Interval thirdInterval = new Interval(3, 5);
        Interval fourthInterval = new Interval(9, 10);
        Interval fifthInterval = new Interval(10, 11);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(firstInterval);
        intervals.add(secondInterval);
        intervals.add(thirdInterval);
        intervals.add(fourthInterval);
        intervals.add(fifthInterval);
        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1, 5));
        expected.add(new Interval(9, 11));
        assertEquals(merger.merge(intervals), expected);
    }
}