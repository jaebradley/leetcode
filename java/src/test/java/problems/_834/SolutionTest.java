package problems._834;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest extends TestCase {

    public void test() {
        assertArrayEquals(
                new int[]{8, 12, 6, 10, 10, 10},
                new Solution().sumOfDistancesInTree(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{2, 3},
                                new int[]{2, 4},
                                new int[]{2, 5}
                        }
                )
        );

        assertArrayEquals(
                new int[]{0},
                new Solution().sumOfDistancesInTree(
                        1,
                        new int[][]{}
                )
        );

        assertArrayEquals(
                new int[]{1, 1},
                new Solution().sumOfDistancesInTree(
                        2,
                        new int[][]{
                                new int[]{1, 0}
                        }
                )
        );
    }
}