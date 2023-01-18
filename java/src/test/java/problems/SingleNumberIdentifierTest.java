package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberIdentifierTest {
    final int[] numbers = new int[] { 1, 2, 4, 1, 3, 3, 4 };

    @Test
    public void itShouldReturnSingleNumber() {
        assertEquals(2, SingleNumberIdentifier.identify(numbers));
    }

    @Test
    public void itShouldReturnSingleNumberXOR() {
        assertEquals(2, SingleNumberIdentifier.identifyXOR(numbers));
    }
}