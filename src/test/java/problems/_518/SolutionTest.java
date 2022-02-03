package problems._518;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                4,
                new Solution().change(
                        5,
                        new int[]{1, 2, 5}
                )
        );

        assertEquals(
                0,
                new Solution().change(
                        3,
                        new int[]{2}
                )
        );

        assertEquals(
                1,
                new Solution().change(
                        10,
                        new int[]{10}
                )
        );
    }
}