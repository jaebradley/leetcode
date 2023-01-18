package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {

    @Test
    public void zeroForZero() {
        assertEquals(0, ClimbingStairs.climbStairs(0));
    }

    @Test
    public void oneForOne() {
        assertEquals(1, ClimbingStairs.climbStairs(1));
    }

    @Test
    public void twoForTwo() {
        assertEquals(2, ClimbingStairs.climbStairs(2));
    }

    @Test
    public void threeForThree() {
        assertEquals(3, ClimbingStairs.climbStairs(3));
    }
}