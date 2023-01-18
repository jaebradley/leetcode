package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {
    @Test
    public void test3x7() {
        assertEquals(
                28,
                new UniquePaths().uniquePaths(3, 7)
        );
    }

    @Test
    public void test1x1() {
        assertEquals(
                1,
                new UniquePaths().uniquePaths(1, 1)
        );
    }

    @Test
    public void test1x10() {
        assertEquals(
                1,
                new UniquePaths().uniquePaths(1, 10)
        );
    }

    @Test
    public void test10x1() {
        assertEquals(
                1,
                new UniquePaths().uniquePaths(10, 1)
        );
    }

    @Test
    public void test2x2() {
        assertEquals(
                2,
                new UniquePaths().uniquePaths(2, 2)
        );
    }

    @Test
    public void test3x3() {
        assertEquals(
                6,
                new UniquePaths().uniquePaths(3, 3)
        );
    }
}