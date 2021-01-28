package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonOverlappingIntervalsTest {

    @Test
    public void testEmpty() {
        assertEquals(
                0,
                new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{})
        );
    }

    @Test
    public void testSingleInterval() {
        assertEquals(
                0,
                new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{new int[]{0, 1}})
        );
    }

    @Test
    public void testTwoBorderingIntervals() {
        assertEquals(
                0,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2}
                        }
                )
        );
    }

    @Test
    public void testTwoSeparatedIntervals() {
        assertEquals(
                0,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{10, 20}
                        }
                )
        );
    }

    @Test
    public void testTwoOverlappingIntervals() {
        assertEquals(
                1,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 3},
                                new int[]{1, 4}
                        }
                )
        );
    }

    @Test
    public void testThreeIntervalsWhereOnlyTwoOverlap() {
        assertEquals(
                1,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 3},
                                new int[]{10, 20},
                                new int[]{2, 4}
                        }
                )
        );
    }

    @Test
    public void testThreeIntervalsWhereAllOverlap() {
        assertEquals(
                2,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 10},
                                new int[]{1, 10},
                                new int[]{2, 10}
                        }
                )
        );
    }

    @Test
    public void testThreeIntervalsWhereAllOverlappedBySingleLargeInterval() {
        assertEquals(
                1,
                new NonOverlappingIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{0, 20},
                                new int[]{1, 10},
                                new int[]{11, 20}
                        }
                )
        );
    }
}