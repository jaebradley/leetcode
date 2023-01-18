package problems._1684;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                2,
                new Solution().countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"})
        );

        assertEquals(
                7,
                new Solution().countConsistentStrings(
                        "abc",
                        new String[]{
                                "a",
                                "b",
                                "c",
                                "ab",
                                "ac",
                                "bc",
                                "abc"
                        }
                )
        );

        assertEquals(
                4,
                new Solution().countConsistentStrings(
                        "cad",
                        new String[]{
                                "cc",
                                "acd",
                                "b",
                                "ba",
                                "bac",
                                "bad",
                                "ac",
                                "d"
                        }
                )
        );
    }
}