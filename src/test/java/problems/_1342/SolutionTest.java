package problems._1342;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                0,
                new Solution().numberOfSteps(0)
        );

        assertEquals(
                1,
                new Solution().numberOfSteps(1)
        );

        assertEquals(
                2,
                new Solution().numberOfSteps(2)
        );

        assertEquals(
                3,
                new Solution().numberOfSteps(3)
        );

        assertEquals(
                3,
                new Solution().numberOfSteps(4)
        );
    }
}