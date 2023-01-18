package problems._1395;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                3,
                new Solution().numTeams(new int[]{ 2, 5, 3, 4, 1 })
        );

        assertEquals(
                0,
                new Solution().numTeams(new int[]{ 2, 1, 3 })
        );

        assertEquals(
                4,
                new Solution().numTeams(new int[]{ 1, 2, 3, 4 })
        );
    }
}