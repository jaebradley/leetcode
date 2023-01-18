package problems._1697;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest extends TestCase {

    public void test() {
        assertArrayEquals(
                new boolean[]{false, true},
                new Solution().distanceLimitedPathsExist(
                        3,
                        new int[][]{
                                new int[]{0, 1, 2},
                                new int[]{1, 2, 4},
                                new int[]{2, 0, 8},
                                new int[]{1, 0, 16}
                        },
                        new int[][]{
                                new int[]{0, 1, 2},
                                new int[]{0, 2, 5}
                        }
                )
        );

        assertArrayEquals(
                new boolean[]{true, false},
                new Solution().distanceLimitedPathsExist(
                        5,
                        new int[][]{
                                new int[]{0, 1, 10},
                                new int[]{1, 2, 5},
                                new int[]{2, 3, 9},
                                new int[]{3, 4, 13}
                        },
                        new int[][]{
                                new int[]{0, 4, 14},
                                new int[]{1, 4, 13}
                        }
                )
        );
    }
}