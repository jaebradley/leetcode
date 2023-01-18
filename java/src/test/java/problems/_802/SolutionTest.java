package problems._802;

import junit.framework.TestCase;

import java.util.List;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                List.of(2, 4, 5, 6),
                new Solution().eventualSafeNodes(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{2, 3},
                                new int[]{5},
                                new int[]{0},
                                new int[]{5},
                                new int[]{},
                                new int[]{}
                        }
                )
        );

        assertEquals(
                List.of(4),
                new Solution().eventualSafeNodes(
                        new int[][]{
                                new int[]{1, 2, 3, 4},
                                new int[]{1, 2},
                                new int[]{3, 4},
                                new int[]{0, 4},
                                new int[]{}
                        }
                )
        );
    }
}