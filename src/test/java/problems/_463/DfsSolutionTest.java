package problems._463;

import junit.framework.TestCase;

public class DfsSolutionTest extends TestCase {

    public void test() {
        assertEquals(
                16,
                new DfsSolution().islandPerimeter(
                        new int[][]{
                                new int[]{0, 1, 0, 0},
                                new int[]{1, 1, 1, 0},
                                new int[]{0, 1, 0, 0},
                                new int[]{1, 1, 0, 0}
                        }
                )
        );

        assertEquals(
                4,
                new DfsSolution().islandPerimeter(new int[][]{new int[]{1}})
        );

        assertEquals(
                4,
                new DfsSolution().islandPerimeter(new int[][]{
                        new int[]{1, 0}
                })
        );
    }
}