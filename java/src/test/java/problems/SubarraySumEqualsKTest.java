package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySumEqualsKTest {

    @Test
    public void threeSubarraySums() {
        assertEquals(4, SubarraySumEqualsK.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }

    @Test
    public void twoSubarraySums() {
        assertEquals(2, SubarraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2));
    }
}