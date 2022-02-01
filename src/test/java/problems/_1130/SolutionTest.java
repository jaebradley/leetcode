package problems._1130;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                32,
                new Solution().mctFromLeafValues(new int[]{6, 2, 4})
        );

        assertEquals(
                44,
                new Solution().mctFromLeafValues(new int[]{4, 11})
        );

        assertEquals(
                32,
                new Solution().mctFromLeafValues(new int[]{6, 4, 2})
        );
    }
}