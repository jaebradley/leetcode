package problems._1443;

import junit.framework.TestCase;

import java.util.List;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                8,
                new Solution().minTime(
                        7,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{1, 4},
                                new int[]{1, 5},
                                new int[]{2, 3},
                                new int[]{2, 6}
                        },
                        List.of(false, false, true, false, true, true, false)
                )
        );

        assertEquals(
                6,
                new Solution().minTime(
                        7,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{1, 4},
                                new int[]{1, 5},
                                new int[]{2, 3},
                                new int[]{2, 6}
                        },
                        List.of(false, false, true, false, false, true, false)
                )
        );

        assertEquals(
                4,
                new Solution().minTime(
                        4,
                        new int[][]{
                                new int[]{0, 2},
                                new int[]{0, 3},
                                new int[]{1, 2}
                        },
                        List.of(false, true, false, false)
                )
        );
    }
}