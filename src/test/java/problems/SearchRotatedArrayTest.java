package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchRotatedArrayTest {

    @Test
    public void findTargetInUnRotatedArray() {
        int[] values = new int[] {0, 1, 2, 4, 5, 6, 7};
        assertEquals(0, SearchRotatedArray.search(values, 0));
    }

    @Test
    public void cannotFindMissingValue() {
        int[] values = new int[] {0, 1, 2, 4, 5, 6, 7};
        assertEquals(-1, SearchRotatedArray.search(values, -1));
    }

    @Test
    public void findLeftTargetInRotatedArray() {
        int[] values = new int[] {6, 7, 0, 1, 2, 4, 5};
        assertEquals(2, SearchRotatedArray.search(values, 0));
    }

    @Test
    public void findRightTargetInRotatedArray() {
        int[] values = new int[] {6, 7, 0, 1, 2, 4, 5};
        assertEquals(5, SearchRotatedArray.search(values, 4));
    }
}