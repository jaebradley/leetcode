package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchA2DMatrix2Test {
    private final int[][] matrix = new int[][] {
            new int[] {1, 4, 7, 11, 15},
            new int[] {2, 5, 8, 12, 19},
            new int[] {3, 6, 9, 26, 22},
            new int[] {10, 13, 14, 17, 24},
            new int[] {18, 21, 23, 26, 30},
    };

    @Test
    public void shouldFind5() {
      assertTrue(SearchA2DMatrix2.searchMatrix(matrix, 5));
    }

    @Test
    public void shouldNotFind20() {
        assertFalse(SearchA2DMatrix2.searchMatrix(matrix, 20));
    }
}