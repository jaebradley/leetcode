package problems._2049;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                3,
                new Solution().countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0})
        );

        assertEquals(
                2,
                new Solution().countHighestScoreNodes(new int[]{-1, 2, 0})
        );
    }
}