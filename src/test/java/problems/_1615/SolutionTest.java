package problems._1615;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                4,
                new Solution().maximalNetworkRank(
                        4,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 3},
                                new int[]{1, 2},
                                new int[]{1, 3}
                        }
                )
        );

        assertEquals(
                5,
                new Solution().maximalNetworkRank(
                        5,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 3},
                                new int[]{1, 2},
                                new int[]{1, 3},
                                new int[]{2, 3},
                                new int[]{2, 4}
                        }
                )
        );

        assertEquals(
                5,
                new Solution().maximalNetworkRank(
                        8,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 3},
                                new int[]{1, 2},
                                new int[]{2, 3},
                                new int[]{2, 4},
                                new int[]{5, 6},
                                new int[]{5, 7}
                        }
                )
        );
    }
}