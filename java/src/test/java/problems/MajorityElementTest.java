package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    @Test
    public void itShouldReturnOneForAlternatingValues() {
        int[] values = new int[] { 1, 2, 1, 3, 1 };
        assertEquals(1, MajorityElement.majorityElement(values));
    }

    @Test
    public void itShouldReturnOneForBunchedValues() {
        int[] values = new int[] { 2, 2, 1, 1, 1 };
        assertEquals(1, MajorityElement.majorityElement(values));
    }

    @Test
    public void itShouldReturnOneForAlternatingAndBunchedValues() {
        int[] values = new int[] { 3, 7, 7, 3, 7 };
        assertEquals(7, MajorityElement.majorityElement(values));
    }
}