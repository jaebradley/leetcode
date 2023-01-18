package problems._476;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                2,
                new Solution().findComplement(5)
        );

        assertEquals(
                0,
                new Solution().findComplement(0)
        );

        assertEquals(
                0,
                new Solution().findComplement(1)
        );

        assertEquals(
                15,
                new Solution().findComplement(16)
        );

        assertEquals(
                7,
                new Solution().findComplement(8)
        );
    }
}