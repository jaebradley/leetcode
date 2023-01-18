package problems._693;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(new Solution().hasAlternatingBits(5));
        assertFalse(new Solution().hasAlternatingBits(7));
        assertFalse(new Solution().hasAlternatingBits(11));
    }
}