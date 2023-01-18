package problems._329;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(
                1,
                new Solution().longestIncreasingPath(
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{0, 0}
                        }
                )
        );
        assertEquals(
                2,
                new Solution().longestIncreasingPath(
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{0, 1}
                        }
                )
        );
        assertEquals(
                2,
                new Solution().longestIncreasingPath(
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 0}
                        }
                )
        );
        assertEquals(
                3,
                new Solution().longestIncreasingPath(
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2}
                        }
                )
        );
        assertEquals(
                3,
                new Solution().longestIncreasingPath(
                        new int[][]{
                                new int[]{0},
                                new int[]{1},
                                new int[]{5},
                                new int[]{5}
                        }
                )
        );
    }
}