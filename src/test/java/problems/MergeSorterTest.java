package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSorterTest {
    @Test
    public void nullArrayShouldNotGetSorted() {
        int[] values = null;
        MergeSorter.sort(values);
        assertNull(values);
    }

    @Test
    public void emptyArrayShouldHaveSameOrder() {
        int[] values = new int[]{};
        MergeSorter.sort(values);
        assertEquals(0, values.length);
    }

    @Test
    public void singleElementArrayShouldHaveSameOrder() {
        int[] values = new int[]{1};
        int[] expected = new int[]{1};
        MergeSorter.sort(values);
        assertArrayEquals(expected, values);
    }

    @Test
    public void outOfOrderTwoElementArrayShouldEndUpOrdered() {
        int[] values = new int[]{2, 1};
        int[] expected = new int[]{1, 2};
        MergeSorter.sort(values);
        assertArrayEquals(expected, values);
    }

    @Test
    public void inOrderTwoElementArrayShouldEndUpOrdered() {
        int[] values = new int[]{1, 2};
        int[] expected = new int[]{1, 2};
        MergeSorter.sort(values);
        assertArrayEquals(expected, values);
    }
}