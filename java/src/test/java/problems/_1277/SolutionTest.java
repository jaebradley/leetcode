package problems._1277;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                15,
                new Solution().countSquares(
                        new int[][]{
                                new int[]{0, 1, 1, 1},
                                new int[]{1, 1, 1, 1},
                                new int[]{0, 1, 1, 1}
                        }
                )
        );

        assertEquals(
                7,
                new Solution().countSquares(
                        new int[][]{
                                new int[]{1, 0, 1},
                                new int[]{1, 1, 0},
                                new int[]{1, 1, 0}
                        }
                )
        );
    }
}