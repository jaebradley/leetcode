package problems._1641;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                5,
                new Solution().countVowelStrings(1)
        );

        assertEquals(
                15,
                new Solution().countVowelStrings(2)
        );

        assertEquals(
                66045,
                new Solution().countVowelStrings(33)
        );
    }
}