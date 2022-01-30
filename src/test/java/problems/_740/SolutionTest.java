package problems._740;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                6,
                new Solution().deleteAndEarn(new int[]{3, 4, 2})
        );

        assertEquals(
                9,
                new Solution().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})
        );
    }
}