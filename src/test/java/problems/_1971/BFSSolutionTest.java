package problems._1971;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BFSSolutionTest {

    @Test
    public void test() {
        assertTrue(new BFSSolution().validPath(
                        3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 0},
                        },
                        0,
                        2
                )
        );

        assertFalse(
                new BFSSolution().validPath(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{3, 5},
                                new int[]{5, 4},
                                new int[]{4, 3}
                        },
                        0,
                        5
                )
        );

        assertTrue(
                new BFSSolution().validPath(
                        10,
                        new int[][]{
                                new int[]{0, 7},
                                new int[]{0, 8},
                                new int[]{6, 1},
                                new int[]{2, 0},
                                new int[]{0, 4},
                                new int[]{5, 8},
                                new int[]{4, 7},
                                new int[]{1, 3},
                                new int[]{3, 5},
                                new int[]{6, 5}
                        },
                        7,
                        5
                )
        );

    }
}