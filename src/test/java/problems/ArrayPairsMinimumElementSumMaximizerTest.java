package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPairsMinimumElementSumMaximizerTest {
    @Test
    public void itShouldReturnMaximumSum() {
        int[] numbers = new int[] {1, 4, 2, 3};
        assertEquals(4, ArrayPairsMinimumElementSumMaximizer.getMaximumSum(numbers));
    }
}