package problems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeIntervalsTest {
    @Test
    public void doesNotMergeTwoNonOverlappingIntervals() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4}
                },
                new MergeIntervals().merge(
                        new int[][]{
                                new int[]{3, 4},
                                new int[]{1, 2}
                        }
                )
        );
    }

    @Test
    public void doesMergeTwoOverlappingIntervals() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 4},
                },
                new MergeIntervals().merge(
                        new int[][]{
                                new int[]{2, 4},
                                new int[]{1, 2}
                        }
                )
        );
    }

    @Test
    public void mergeConnectedComponents() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 5},
                },
                new MergeIntervals().merge(
                        new int[][]{
                                new int[]{4, 5},
                                new int[]{2, 4},
                                new int[]{1, 3}
                        }
                )
        );
    }

    @Test
    public void testEmptyIntervals() {
        assertArrayEquals(
                new int[][]{},
                new MergeIntervals().merge(new int[][]{})
        );
    }

    @Test
    public void testSingleInterval() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 10}
                },
                new MergeIntervals().merge(
                        new int[][]{
                                new int[]{1, 10}
                        }
                )
        );
    }

    @Test
    public void mergeTwoDifferentConnectedComponents() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 10}
                },
                new MergeIntervals().merge(
                        new int[][]{
                                new int[]{5, 10},
                                new int[]{1, 2},
                                new int[]{1, 3},
                                new int[]{3, 7}
                        }
                )
        );
    }
}