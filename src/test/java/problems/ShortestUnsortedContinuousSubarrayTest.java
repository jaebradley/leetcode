package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestUnsortedContinuousSubarrayTest {

    @Test
    public void continuousSubarrayOfFive() {
        assertEquals(5, ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    @Test
    public void continuousSubarrayOfZeroForSortedArray() {
        assertEquals(0, ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{2, 4, 6, 8, 10}));
    }

    @Test
    public void continuousSubarrayOfZeroForSingleElementArray() {
        assertEquals(0, ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{1}));
    }

    @Test
    public void continuousSubarrayOfOne() {
        assertEquals(2, ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}));
    }

    @Test
    public void continuousSubarrayOfFour() {
        assertEquals(4, ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
    }
}