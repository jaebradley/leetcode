package problems._1466;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                3,
                new Solution().minReorder(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 3},
                                new int[]{2, 3},
                                new int[]{4, 0},
                                new int[]{4, 5}
                        }
                )
        );

        assertEquals(
                2,
                new Solution().minReorder(
                        5,
                        new int[][]{
                                new int[]{1, 0},
                                new int[]{1, 2},
                                new int[]{3, 2},
                                new int[]{3, 4}
                        }
                )
        );
    }
}