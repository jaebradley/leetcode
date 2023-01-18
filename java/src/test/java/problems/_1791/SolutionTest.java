package problems._1791;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                2,
                new Solution().findCenter(
                        new int[][]{
                                new int[]{1,2},
                                new int[]{2,3},
                                new int[]{4,2}
                        }
                )
        );

        assertEquals(
                1,
                new Solution().findCenter(
                        new int[][]{
                                new int[]{1,2},
                                new int[]{5,1},
                                new int[]{1,3},
                                new int[]{1,4}
                        }
                )
        );
    }
}