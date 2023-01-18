package problems._1334;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                3,
                new Solution().findTheCity(
                        4,
                        new int[][]{
                                new int[]{0, 1, 3},
                                new int[]{1, 2, 1},
                                new int[]{1, 3, 4},
                                new int[]{2, 3, 1}
                        },
                        4
                )
        );

        assertEquals(
                0,
                new Solution().findTheCity(
                        5,
                        new int[][]{
                                new int[]{0, 1, 2},
                                new int[]{0, 4, 8},
                                new int[]{1, 2, 3},
                                new int[]{1, 4, 2},
                                new int[]{2, 3, 1},
                                new int[]{3, 4, 1}
                        },
                        2
                )
        );
    }
}