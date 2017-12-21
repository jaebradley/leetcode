package problems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayProductExceptSelfCalculatorTest {
    @Test
    public void itShouldReturnCalculatedProducts() {
        final int[] values = new int[] { 2, 3, 4, 5 };
        final int[] expected = new int[] { 60, 40, 30, 24 };
        assertArrayEquals(ArrayProductExceptSelfCalculator.calculate(values), expected);
    }

    @Test
    public void itShouldReturnEmptyArrayForEmptyValues() {
        assertArrayEquals(ArrayProductExceptSelfCalculator.calculate(new int[] {}), new int[] {});
    }

    @Test
    public void itShouldReturnEmptyArrayForSingleValue() {
        assertArrayEquals(ArrayProductExceptSelfCalculator.calculate(new int[] {1}), new int[] {});
    }

    @Test
    public void itShouldCalculateForTwoValues() {
        assertArrayEquals(ArrayProductExceptSelfCalculator.calculate(new int[] {0, 1}), new int[] {1, 0});
    }

    @Test
    public void itShouldCalculateForNegativeValues() {
        final int[] values = new int[] { -2, 3, -4, 5 };
        final int[] expected = new int[] { -60, 40, -30, 24 };
        assertArrayEquals(ArrayProductExceptSelfCalculator.calculate(values), expected);
    }

}