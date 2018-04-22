package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestElementInAnArrayTest {

    @Test
    public void fiveShouldBeSecondLargestElement() {
        assertEquals(5, KthLargestElementInAnArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}