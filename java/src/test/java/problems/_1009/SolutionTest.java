package problems._1009;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(2, new Solution().bitwiseComplement(5));
        assertEquals(0, new Solution().bitwiseComplement(7));
        assertEquals(5, new Solution().bitwiseComplement(10));
    }
}