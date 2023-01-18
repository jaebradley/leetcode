package problems._1319;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(
                1,
                new Solution().makeConnected(
                        4,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{1, 2}
                        }
                )
        );
        assertEquals(
                2,
                new Solution().makeConnected(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{0, 3},
                                new int[]{1, 2},
                                new int[]{1, 3}
                        }
                )
        );

        assertEquals(
                -1,
                new Solution().makeConnected(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{0, 3},
                                new int[]{1, 2}
                        }
                )
        );

        assertEquals(
                -1,
                new Solution().makeConnected(
                        2,
                        new int[][]{}
                )
        );

        assertEquals(
                0,
                new Solution().makeConnected(
                        1,
                        new int[][]{}
                )
        );
    }
}