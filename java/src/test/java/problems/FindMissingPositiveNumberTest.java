package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMissingPositiveNumberTest {
    private final int[] withNegatives = new int[] { 3, 2, -1, 0, -2, -100, 1 };
    private final int[] withPositives = new int[] { 1, 3, 2, 5, 4 };

    @Test
    public void itShouldReturnFour() {
        assertEquals(4, FindMissingPositiveNumber.firstMissingPositive(withNegatives));
    }

    @Test
    public void itShouldReturnSix() {
        assertEquals(6, FindMissingPositiveNumber.firstMissingPositive(withPositives));
    }
}