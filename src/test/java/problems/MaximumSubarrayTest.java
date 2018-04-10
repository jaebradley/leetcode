package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    @Test
    public void singleElementArray() {
        assertEquals(2, MaximumSubarray.maxSubArray(new int[]{2}));
    }

    @Test
    public void twoElementArrayWithOneNegative() {
        assertEquals(2, MaximumSubarray.maxSubArray(new int[]{-2, 2}));
    }

    @Test
    public void twoElementArrayWithTwoNegatives() {
        assertEquals(-2, MaximumSubarray.maxSubArray(new int[]{-3, -2}));
    }

    @Test
    public void twoElementArrayWithNoNegatives() {
        assertEquals(5, MaximumSubarray.maxSubArray(new int[]{2, 3}));
    }

    @Test
    public void nineElementArrayWithMixture() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}