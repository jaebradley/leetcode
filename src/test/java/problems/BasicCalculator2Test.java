package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculator2Test {

    @Test
    public void calculateSumOfTwoIntegers() {
        assertEquals(3, BasicCalculator2.calculate("2+1"));
    }

    @Test
    public void calculateDifferenceOfTwoIntegers() {
        assertEquals(0, BasicCalculator2.calculate("2-2"));
    }

    @Test
    public void calculateSumAndDifferenceOfThreeIntegers() {
        assertEquals(1, BasicCalculator2.calculate("2+3-4"));
    }

    @Test
    public void calculateProductOfTwoIntegers() {
        assertEquals(6, BasicCalculator2.calculate("2*3"));
    }

    @Test
    public void calculateDivisionOfTwoIntegers() {
        assertEquals(3, BasicCalculator2.calculate("6/2"));
    }

    @Test
    public void divisionShouldRoundDown() {
        assertEquals(1, BasicCalculator2.calculate("3/2"));
    }

    @Test
    public void calculateWithSumAndProduct() {
        assertEquals(7, BasicCalculator2.calculate("1+3*2"));
    }

    @Test
    public void calculateWithSumAndDivision() {
        assertEquals(5, BasicCalculator2.calculate("3+5/2"));
    }

    @Test
    public void calculateWithSumDivisionAndProduct() {
        assertEquals(2, BasicCalculator2.calculate("6+2-6/2*2"));
    }

    @Test
    public void calculateNumberWithoutOperator() {
        assertEquals(42, BasicCalculator2.calculate("42"));
    }

    @Test
    public void calculateSubtractionTwoDigitNumber() {
        assertEquals(-22, BasicCalculator2.calculate("0-22"));
    }
}