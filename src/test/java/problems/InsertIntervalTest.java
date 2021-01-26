package problems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertIntervalTest {

    @Test
    public void testInsertingNonOverlappingInterval() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6},
                        new int[]{7, 8}
                },
                new InsertInterval().insert(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{5, 6},
                                new int[]{7, 8}
                        },
                        new int[]{3, 4}
                )
        );
    }

    @Test
    public void testInsertingIntervalAtBeginningAndMerging() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 4},
                        new int[]{5, 6}
                },
                new InsertInterval().insert(
                        new int[][]{
                                new int[]{2, 4},
                                new int[]{5, 6}
                        },
                        new int[]{1, 2}
                )
        );

    }

    @Test
    public void testInsertingIntervalAtBeginning() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6}
                },
                new InsertInterval().insert(
                        new int[][]{
                                new int[]{3, 4},
                                new int[]{5, 6}
                        },
                        new int[]{1, 2}
                )
        );
    }

    @Test
    public void testEmptyIntervals() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2}
                },
                new InsertInterval().insert(
                        new int[][]{},
                        new int[]{1, 2}
                )
        );
    }

    @Test
    public void testInsertingIntervalCausesTwoIntervalsToMerge() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 6},
                        new int[]{7, 8}
                },
                new InsertInterval().insert(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 4},
                                new int[]{5, 6},
                                new int[]{7, 8}
                        },
                        new int[]{4, 5}
                )
        );
    }

    @Test
    public void testInsertingSingleOverlappingInterval() {
        assertArrayEquals(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 5},
                        new int[]{6, 7}
                },
                new InsertInterval().insert(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 4},
                                new int[]{6, 7}
                        },
                        new int[]{3, 5}
                )
        );
    }
}