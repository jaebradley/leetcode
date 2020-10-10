package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameThreeTest {

    @Test
    public void testSingleZero() {
        assertTrue(
                new JumpGameThree().canReach(
                        new int[]{ 4, 2, 3, 0, 3, 1, 2},
                        5
                )
        );
    }

    @Test
    public void testStartAtZero() {
        assertTrue(
                new JumpGameThree().canReach(
                        new int[]{ 1, 2, 3, 0, 3, 2, 1 },
                        3
                )
        );
    }

    @Test
    public void testCannotReachSingleZero() {
        assertFalse(
               new JumpGameThree().canReach(
                       new int[]{ 3, 0, 2, 1, 2 },
                       2
               )
        );
    }

    @Test
    public void testCannotReachMultipleZeroes() {
        assertFalse(
                new JumpGameThree().canReach(
                        new int[]{ 2, 0, 2, 0, 2 },
                        0
                )
        );
    }
}