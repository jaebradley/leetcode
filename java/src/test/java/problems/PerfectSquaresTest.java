package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectSquaresTest {

    @Test
    public void zeroForZero() {
        assertEquals(0, PerfectSquares.numSquares(0));
    }

    @Test
    public void oneForOne() {
        assertEquals(1, PerfectSquares.numSquares(1));
    }

    @Test
    public void twoForTwo() {
        assertEquals(2, PerfectSquares.numSquares(2));
    }

    @Test
    public void oneForFour() {
        assertEquals(1, PerfectSquares.numSquares(4));
    }

    @Test
    public void threeForTwelve() {
        assertEquals(3, PerfectSquares.numSquares(12));
    }

    @Test
    public void twoForThirteen() {
        assertEquals(2, PerfectSquares.numSquares(13));
    }
}