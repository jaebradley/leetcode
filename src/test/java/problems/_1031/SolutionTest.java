package problems._1031;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                20,
                new Solution().maxSumTwoNoOverlap(
                        new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4},
                        1,
                        2
                )
        );

        assertEquals(
                29,
                new Solution().maxSumTwoNoOverlap(
                        new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0},
                        3,
                        2
                )
        );

        assertEquals(
                31,
                new Solution().maxSumTwoNoOverlap(
                        new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8},
                        4,
                        3
                )
        );
    }
}