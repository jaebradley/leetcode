package problems._990;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==a"
                        }
                )
        );

        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b!=c"
                        }
                )
        );

        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==c"
                        }
                )
        );

        assertFalse(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b!=a"
                        }
                )
        );

        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==a",
                                "c==b"
                        }
                )
        );

        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==a",
                                "c==a"
                        }
                )
        );

        assertTrue(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==a",
                                "c!=a"
                        }
                )
        );

        assertFalse(
                new Solution().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==c",
                                "c!=a"
                        }
                )
        );
    }
}