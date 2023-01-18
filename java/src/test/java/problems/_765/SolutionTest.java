package problems._765;

import junit.framework.TestCase;

import java.util.Map;

public class SolutionTest extends TestCase {

    public void test() {
        Map.of(
                        1, new int[]{0, 2, 1, 3},
                        0, new int[]{3, 2, 0, 1}
                )
                .forEach(
                        (k, v) -> assertEquals((int) k, new Solution().minSwapsCouples(v))
                );
    }
}