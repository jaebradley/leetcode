package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProductSubarrayTest {
    @Test
    public void testZeroWhenOtherProductsAreNegative() {
        assertEquals(
                0,
                new MaximumProductSubarray().maxProduct(
                        new int[]{-2, 0, -10}
                )
        );
    }

    @Test
    public void testThreeConsecutiveNegativeNumbers() {
        assertEquals(
                50,
                new MaximumProductSubarray().maxProduct(
                        new int[]{-2, -5, -10}
                )
        );
    }

    @Test
    public void testSingleNegativeNumber() {
        assertEquals(
                -10,
                new MaximumProductSubarray().maxProduct(
                        new int[]{-10}
                )
        );
    }

    @Test
    public void testTwoNegativesAndPositives() {
        assertEquals(
                720,
                new MaximumProductSubarray().maxProduct(
                        new int[]{1, 2, -3, 4, -5, 6}
                )
        );
    }
}