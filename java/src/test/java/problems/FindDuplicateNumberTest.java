package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicateNumberTest {

    @Test
    public void testThreeValues() {
        assertEquals(2, FindDuplicateNumber.findDuplicate(new int[]{2, 2, 2}));
    }

    @Test
    public void testTwoValues() {
        assertEquals(1, FindDuplicateNumber.findDuplicate(new int[]{1, 1}));
    }

    @Test
    public void testFiveValues() {
        assertEquals(2, FindDuplicateNumber.findDuplicate(new int[]{1, 2, 3, 2, 4}));
    }

    @Test
    public void testSixValues() {
        assertEquals(1, FindDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 1}));
    }
}