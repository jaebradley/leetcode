package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayDuplicateRemoverTest {

    @Test
    public void itShouldReturn0ForEmptyArray() {
        assertEquals(0, SortedArrayDuplicateRemover.removeDuplicates(new int[]{}));
    }

    @Test
    public void itShouldReturn1ForSingleDistinctElementArray() {
        assertEquals(1, SortedArrayDuplicateRemover.removeDuplicates(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void itShouldReturn2ForTwoDistinctElementArray() {
        assertEquals(2, SortedArrayDuplicateRemover.removeDuplicates(new int[]{1, 1, 1, 1, 2}));
    }

    @Test
    public void itShouldReturn2ForTwoDistinctMultiElementArray() {
        assertEquals(2, SortedArrayDuplicateRemover.removeDuplicates(new int[] {1, 1, 1, 1, 2, 2, 2, 2, 2}));
    }
}