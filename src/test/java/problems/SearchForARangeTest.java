package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchForARangeTest {
    private final int[] unsuccessfulSearchRange = new int[] { -1, -1 };

    @Test
    public void cannotFindRange() {
        assertArrayEquals(SearchForARange.searchRange(new int[] {5, 7, 7, 8, 8, 10 }, 6), unsuccessfulSearchRange);
    }

    @Test
    public void canFindRange() {
        assertArrayEquals(SearchForARange.searchRange(new int[] {5, 7, 7, 8, 8, 10 }, 8), new int[] { 3, 4 });
    }
}