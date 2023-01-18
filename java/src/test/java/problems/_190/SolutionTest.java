package problems._190;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                -1073741825,
                new Solution().reverseBits(-3)
        );

        assertEquals(43261596, new Solution().reverseBits(964176192));
    }
}