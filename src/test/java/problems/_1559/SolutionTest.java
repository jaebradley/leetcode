package problems._1559;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        assertTrue(
                new Solution().containsCycle(
                        new char[][]{
                                new char[]{'a', 'a', 'a', 'a'},
                                new char[]{'a', 'b', 'b', 'a'},
                                new char[]{'a', 'b', 'b', 'a'},
                                new char[]{'a', 'a', 'a', 'a'}
                        }
                )
        );

        assertFalse(
                new Solution().containsCycle(
                        new char[][]{
                                new char[]{'a', 'b', 'b'},
                                new char[]{'b', 'z', 'b'},
                                new char[]{'b', 'b', 'a'}
                        }
                )
        );
    }
}