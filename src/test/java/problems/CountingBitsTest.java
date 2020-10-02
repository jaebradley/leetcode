package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingBitsTest {
    @Test
    public void testCountZeroBits() {
        assertArrayEquals(
                new int[]{0},
                new CountingBits().countBits(0)
        );
    }

    @Test
    public void testCountOneBits() {
        assertArrayEquals(
                new int[]{0, 1},
                new CountingBits().countBits(1)
        );
    }

    @Test
    public void testCountTwoBits() {
        assertArrayEquals(
                new int[]{0, 1, 1},
                new CountingBits().countBits(2)
        );
    }

    @Test
    public void testCountThreeBits() {
        assertArrayEquals(
                new int[]{0, 1, 1, 2},
                new CountingBits().countBits(3)
        );
    }

    @Test
    public void testCountFourBits() {
        assertArrayEquals(
                new int[]{0, 1, 1, 2, 1},
                new CountingBits().countBits(4)
        );
    }

    @Test
    public void testCount16Bits() {
        assertArrayEquals(
                new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1},
                new CountingBits().countBits(16)
        );
    }
}
