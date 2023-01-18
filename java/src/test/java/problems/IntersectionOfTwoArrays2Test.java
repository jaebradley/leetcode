package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionOfTwoArrays2Test {
    @Test
    public void itShouldReturnEmptyArray() {
        int[] firstValues = new int[] {1, 2, 3, 4};
        int[] secondValues = new int[] {5, 6, 7, 8};
        assertArrayEquals(new int[] {}, IntersectionOfTwoArrays2.intersect(firstValues, secondValues));
    }

    @Test
    public void itShouldReturnSecondArray() {
        int[] firstValues = new int[] {1, 2, 2, 1};
        int[] secondValues = new int[] {2, 2};
        assertArrayEquals(secondValues, IntersectionOfTwoArrays2.intersect(firstValues, secondValues));
    }

    @Test
    public void itShouldReturnEitherArray() {
        int[] firstValues = new int[] {1, 2, 3, 4};
        int[] secondValues = new int[] {1, 2, 3, 4};
        assertArrayEquals(firstValues, IntersectionOfTwoArrays2.intersect(firstValues, secondValues));
    }

    @Test
    public void itShouldReturn() {
        int[] firstValues = new int[] {1, 0};
        int[] secondValues = new int[] {1, 2};
        assertArrayEquals(new int[] {1}, IntersectionOfTwoArrays2.intersect(firstValues, secondValues));
    }
}