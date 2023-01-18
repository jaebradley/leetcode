package problems._1911;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                7,
                new Solution().maxAlternatingSum(new int[]{4, 2, 5, 3})
        );

        assertEquals(
                8,
                new Solution().maxAlternatingSum(new int[]{5, 6, 7, 8})
        );

        assertEquals(
                10,
                new Solution().maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5})
        );
    }
}