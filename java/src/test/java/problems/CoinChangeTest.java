package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {
    @Test
    public void testUseSingleCoinTwice() {
        assertEquals(
                3,
                new CoinChange().coinChange(
                        new int[]{1, 2, 5},
                        11
                )
        );
    }

    @Test
    public void testSingleCoinDoesNotMatchCost() {
        assertEquals(
                -1,
                new CoinChange().coinChange(
                        new int[]{2},
                        3
                )
        );
    }

    @Test
    public void testCostOfZero() {
        assertEquals(
                0,
                new CoinChange().coinChange(
                        new int[]{1},
                        0
                )
        );
    }

    @Test
    public void testSingleCoinMatchesCost() {
        assertEquals(
                1,
                new CoinChange().coinChange(
                        new int[]{3},
                        3
                )
        );
    }
}