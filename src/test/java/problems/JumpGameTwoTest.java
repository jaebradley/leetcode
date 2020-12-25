package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTwoTest {
    @Test
    public void testMinimumNumberWhenTwoOptions() {
        assertEquals(3, new JumpGameTwo().jump(new int[]{2, 1, 1, 1, 1}));
    }

    @Test
    public void testSingleJump() {
        assertEquals(1, new JumpGameTwo().jump(new int[]{4, 1, 1, 1, 1}));
    }

    @Test
    public void testPossibleIndexGreaterThanLastElementIndex() {
        assertEquals(1, new JumpGameTwo().jump(new int[]{ 4, 10, 1, 1, 1}));
    }
}