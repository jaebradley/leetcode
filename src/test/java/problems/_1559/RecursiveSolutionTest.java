package problems._1559;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveSolutionTest {
    @Test
    public void test() {
        assertTrue(
                new RecursiveSolution().containsCycle(
                        new char[][]{
                                new char[]{'a', 'a', 'a', 'a'},
                                new char[]{'a', 'b', 'b', 'a'},
                                new char[]{'a', 'b', 'b', 'a'},
                                new char[]{'a', 'a', 'a', 'a'}
                        }
                )
        );

        assertFalse(
                new RecursiveSolution().containsCycle(
                        new char[][]{
                                new char[]{'a', 'b', 'b'},
                                new char[]{'b', 'z', 'b'},
                                new char[]{'b', 'b', 'a'}
                        }
                )
        );

        assertTrue(
                new RecursiveSolution().containsCycle(
                        new char[][]{
                                new char[]{'c', 'c', 'c', 'a'},
                                new char[]{'c', 'd', 'c', 'c'},
                                new char[]{'c', 'c', 'e', 'c'},
                                new char[]{'f', 'c', 'c', 'c'},
                        }
                )
        );
    }
}