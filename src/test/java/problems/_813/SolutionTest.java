package problems._813;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                (double) 20,
                new Solution().largestSumOfAverages(
                        new int[]{9, 1, 2, 3, 9},
                        3
                )
        );

        assertEquals(
                20.5,
                new Solution().largestSumOfAverages(
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        4
                )
        );
    }
}