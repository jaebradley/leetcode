package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourSumCounterTest {

    @Test
    public void itShouldReturnTwo() {
        int[] A = new int[] { 1, 2 };
        int[] B = new int[] { -2, -1 };
        int[] C = new int[] { -1, 2 };
        int[] D = new int[] { 0, 2 };

        assertEquals(2, FourSumCounter.fourSumCount(A, B, C, D));
    }

    @Test
    public void itShouldReturnSix() {
        int[] A = new int[] { -1, -1 };
        int[] B = new int[] { -1, 1 };
        int[] C = new int[] { -1, 1 };
        int[] D = new int[] { 1, -1 };

        assertEquals(6, FourSumCounter.fourSumCount(A, B, C, D));
    }

    @Test
    public void itShouldReturnZero() {
        int[] A = new int[] { 1, 100 };
        int[] B = new int[] { 1000, 10000 };
        int[] C = new int[] { 100000, 1000000 };
        int[] D = new int[] { 10000000, 10000000 };

        assertEquals(0, FourSumCounter.fourSumCount(A, B, C, D));
    }
}