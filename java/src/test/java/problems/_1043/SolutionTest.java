package problems._1043;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                84,
                new Solution().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)
        );

        assertEquals(
                83,
                new Solution().maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)
        );

        assertEquals(
                1,
                new Solution().maxSumAfterPartitioning(new int[]{1}, 1)
        );
    }
}