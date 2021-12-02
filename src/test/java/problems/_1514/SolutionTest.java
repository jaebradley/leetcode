package problems._1514;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                0.25,
                new Solution().maxProbability(
                        3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{0, 2}
                        },
                        new double[]{0.5, 0.5, 0.2},
                        0,
                        2
                )
        );

        assertEquals(
                0.0,
                new Solution().maxProbability(
                        3,
                        new int[][]{
                                new int[]{0, 1}
                        },
                        new double[]{0.5},
                        0,
                        2
                )
        );

        assertEquals(
                0.3,
                new Solution().maxProbability(
                        3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{0, 2}
                        },
                        new double[]{0.5, 0.5, 0.3},
                        0,
                        2
                )
        );
    }
}