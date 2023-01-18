package problems._947;

import junit.framework.TestCase;

import java.util.Map;

public class SolutionTest extends TestCase {

    public void test() {
        Map.of(
                5,
                new int[][]{
                        new int[]{0,0},
                        new int[]{0,1},
                        new int[]{1,0},
                        new int[]{1,2},
                        new int[]{2,1},
                        new int[]{2,2}
                },
                3,
                new int[][]{
                        new int[]{0,0},
                        new int[]{0,2},
                        new int[]{1,1},
                        new int[]{2,0},
                        new int[]{2,2}
                }
        )
                .forEach(
                        (k,v) -> assertEquals((int) k, new Solution().removeStones(v))
                );

    }
}