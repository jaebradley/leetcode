package problems._547;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(
                2,
                new Solution().findCircleNum(
                        new int[][]{
                                new int[]{1, 1, 0},
                                new int[]{1, 1, 0},
                                new int[]{0, 0, 1}
                        }
                )
        );
    }
}