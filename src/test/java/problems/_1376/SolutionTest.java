package problems._1376;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                0,
                new Solution().numOfMinutes(
                        1,
                        0,
                        new int[]{-1},
                        new int[]{0}
                )
        );

        assertEquals(
                1,
                new Solution().numOfMinutes(
                        6,
                        2,
                        new int[]{2, 2, -1, 2, 2},
                        new int[]{0, 0, 1, 0, 0, 0}
                )
        );

        assertEquals(
                3,
                new Solution().numOfMinutes(
                        3,
                        0,
                        new int[]{-1, 0, 1},
                        new int[]{1, 2, 0}
                )
        );

        assertEquals(
                3,
                new Solution().numOfMinutes(
                        15,
                        0,
                        new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}
                )
        );
    }
}