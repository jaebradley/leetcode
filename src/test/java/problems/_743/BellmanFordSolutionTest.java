package problems._743;

import junit.framework.TestCase;

public class BellmanFordSolutionTest extends TestCase {
    public void test() {
        assertEquals(
                2,
                new BellmanFordSolution().networkDelayTime(
                        new int[][]{
                                new int[]{2, 1, 1},
                                new int[]{2, 3, 1},
                                new int[]{3, 4, 1}
                        },
                        4,
                        2
                )
        );

        assertEquals(
                1,
                new BellmanFordSolution().networkDelayTime(
                        new int[][]{
                                new int[]{1, 2, 1}
                        },
                        2,
                        1
                )
        );

        assertEquals(
                -1,
                new BellmanFordSolution().networkDelayTime(
                        new int[][]{
                                new int[]{1, 2, 1}
                        },
                        2,
                        2
                )
        );
    }
}