package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInsertPositionTest {

    private final int[] values = new int[] {1, 3, 5, 6};

    @Test
    public void itShouldReturnTwo() {
        assertEquals(2, SearchInsertPosition.searchInsert(values, 5));
    }

    @Test
    public void itShouldReturnOne() {
        assertEquals(1, SearchInsertPosition.searchInsert(values, 2));
    }

    @Test
    public void itShouldReturnZero() {
        assertEquals(0, SearchInsertPosition.searchInsert(values, 0));
    }

    @Test
    public void itShouldReturnFour() {
        assertEquals(4, SearchInsertPosition.searchInsert(values, 7));
    }
}