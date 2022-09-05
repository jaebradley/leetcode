package problems._2101;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                2,
                new Solution().maximumDetonation(
                        new int[][]{
                                new int[]{2,1,3},
                                new int[]{6,1,4}
                        }
                )
        );

        assertEquals(
                1,
                new Solution().maximumDetonation(
                        new int[][]{
                                new int[]{1,1,5},
                                new int[]{10,10,5}
                        }
                )
        );

        assertEquals(
                5,
                new Solution().maximumDetonation(
                        new int[][]{
                                new int[]{1,2,3},
                                new int[]{2,3,1},
                                new int[]{3,4,2},
                                new int[]{4,5,3},
                                new int[]{5,6,4}
                        }
                )
        );

        assertEquals(
                2,
                new Solution().maximumDetonation(
                        new int[][]{
                                new int[]{4,4,3},
                                new int[]{4,4,3}
                        }
                )
        );

        assertEquals(
                1,
                new Solution().maximumDetonation(
                        new int[][]{
                                new int[]{1,1,1}
                        }
                )
        );
    }
}