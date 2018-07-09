package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {

    @Test
    public void nullIsZero() {
        assertEquals(0, MinimumPathSum.minPathSum(null));
    }

    @Test
    public void emptyGridIsZero() {
        assertEquals(0, MinimumPathSum.minPathSum(new int[][] {}));
    }

    @Test
    public void singleElementGridIsSingleElementValue() {
        assertEquals(10, MinimumPathSum.minPathSum(new int[][] { new int[] {10} }));
    }

    @Test
    public void twoElementSingleRow() {
        assertEquals(10, MinimumPathSum.minPathSum(new int[][] { new int[] {4, 6} }));
    }

    @Test
    public void twoSingleElementRows() {
        assertEquals(10, MinimumPathSum.minPathSum(new int[][] { new int[] {4}, new int[] {6} }));
    }

    @Test
    public void threeByThreeGrid() {
        assertEquals(7, MinimumPathSum.minPathSum(new int[][] {
                new int[] {1, 3, 1},
                new int[] {1, 5, 1},
                new int[] {4, 2, 1},
        }));
    }
}