package problems._931;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                13,
                new Solution().minFallingPathSum(
                        new int[][]{
                                new int[]{2, 1, 3},
                                new int[]{6, 5, 4},
                                new int[]{7, 8, 9}
                        }
                )
        );

        assertEquals(
                -59,
                new Solution().minFallingPathSum(
                        new int[][]{
                                new int[]{-19, 57},
                                new int[]{-40, -5}
                        }
                )
        );
    }
}