package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {

    @Test
    public void maxAmountIsNine() {
        assertEquals(9, HouseRobber.rob(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void maxAmountIs16() {
        assertEquals(16, HouseRobber.rob(new int[]{1, 2, 10, 1, 1, 5}));
    }

    @Test
    public void emptyArrayMaxAmountIsZero() {
        assertEquals(0, HouseRobber.rob(new int[]{}));
    }
}