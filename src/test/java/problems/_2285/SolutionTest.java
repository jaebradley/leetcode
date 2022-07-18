package problems._2285;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                43,
                new Solution().maximumImportance(
                        5,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 3},
                                new int[]{0, 2},
                                new int[]{1, 3},
                                new int[]{2, 4}
                        }
                )
        );

        assertEquals(
                20,
                new Solution().maximumImportance(
                        5,
                        new int[][]{
                                new int[]{0, 3},
                                new int[]{2, 4},
                                new int[]{1, 3}
                        }
                )
        );

        assertEquals(
                9,
                new Solution().maximumImportance(
                        5,
                        new int[][]{
                                new int[]{0, 1},
                        }
                )
        );
    }
}