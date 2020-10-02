package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOfTwoTest {
    @Test
    public void testNegative3IsNotAPowerOfTwo() {
        assertFalse(new PowerOfTwo().isPowerOfTwo(-3));
    }

    @Test
    public void testNegativeTwoIsNotAPowerOfTwo() {
        assertFalse(new PowerOfTwo().isPowerOfTwo(-2));
    }

    @Test
    public void testNegativeOneIsNotAPowerOfTwo() {
        assertFalse(new PowerOfTwo().isPowerOfTwo(-1));
    }

    @Test
    public void testZeroIsNotAPowerOfTwo() {
        assertFalse(new PowerOfTwo().isPowerOfTwo(0));
    }

    @Test
    public void testOneIsAPowerOfTwo() {
        assertTrue(new PowerOfTwo().isPowerOfTwo(1));
    }

    @Test
    public void testTwoIsAPowerOfTwo() {
        assertTrue(new PowerOfTwo().isPowerOfTwo(2));
    }

    @Test
    public void testThreeIsNotAPowerOfTwo() {
        assertFalse(new PowerOfTwo().isPowerOfTwo(3));
    }

    @Test
    public void testFourIsAPowerOfTwo() {
        assertTrue(new PowerOfTwo().isPowerOfTwo(4));
    }

    @Test
    public void testFiveIsNotAPowerOfTwo() {
       assertFalse(new PowerOfTwo().isPowerOfTwo(5));
    }
}
