package problems._1361;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(new Solution().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        assertFalse(new Solution().validateBinaryTreeNodes(3, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        assertFalse(new Solution().validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
        assertFalse(new Solution().validateBinaryTreeNodes(4, new int[]{1, 0, 3, -1}, new int[]{-1, -1, -1, -1}));
    }
}