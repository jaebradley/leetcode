package problems._97;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertTrue(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(new Solution().isInterleave("aabcc", "dbbca", "aadbbaccc"));
        assertTrue(new Solution().isInterleave("", "", ""));
    }
}