package problems._503;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest extends TestCase {

    public void test() {
        assertArrayEquals(
                new int[]{2, -1, 2},
                new Solution().nextGreaterElements(new int[]{1, 2, 1})
        );
        assertArrayEquals(
                new int[]{2, 3, 4, -1, 4},
                new Solution().nextGreaterElements(new int[]{1, 2, 3, 4, 3})
        );
    }
}