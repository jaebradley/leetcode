package problems._2220;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(3, new Solution().minBitFlips(10, 7));
        assertEquals(3, new Solution().minBitFlips(3, 4));
    }
}