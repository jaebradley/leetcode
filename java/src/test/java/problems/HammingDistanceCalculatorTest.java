package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class HammingDistanceCalculatorTest {

    @Test
    public void itShouldReturnTwo() {
        assertEquals(2, HammingDistanceCalculator.calculateDistance(4, 2));
    }
}