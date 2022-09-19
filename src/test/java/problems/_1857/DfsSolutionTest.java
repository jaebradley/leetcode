package problems._1857;

import junit.framework.TestCase;

public class DfsSolutionTest extends TestCase {
    public void test() {
        assertEquals(
                3,
                new DfsSolution().largestPathValue(
                        "abaca",
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{2, 3},
                                new int[]{3, 4}
                        }
                )
        );

        assertEquals(
                -1,
                new DfsSolution().largestPathValue("a", new int[][]{new int[]{0,0}})
        );
    }
}