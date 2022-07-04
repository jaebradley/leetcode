package problems._405;

import junit.framework.TestCase;

import java.util.Map;

public class SolutionTest extends TestCase {

    public void test() {
        Map.of(
                        "1a", 26,
                        "ffffffff", -1,
                        "0", 0
                )
                .forEach((k, v) -> assertEquals(k, new Solution().toHex(v)));
    }
}