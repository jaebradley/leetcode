package problems._1578;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                3,
                new Solution().minCost("abaac", new int[]{1, 2, 3, 4, 5})
        );

        assertEquals(
                0,
                new Solution().minCost("abc", new int[]{1, 2, 3})
        );

        assertEquals(
                2,
                new Solution().minCost("aaa", new int[]{1, 3, 1})
        );
    }
}