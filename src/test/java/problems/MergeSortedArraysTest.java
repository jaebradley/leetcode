package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArraysTest {

    @Test
    public void shouldTwoArraysWhereAllElementsInOneAreGreaterThanOther() {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        MergeSortedArrays.merge(nums1, 3, nums2, 3);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void shouldTwoArraysWhereAllElementsInTwoAreGreaterThanOther() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{4, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        MergeSortedArrays.merge(nums1, 3, nums2, 3);
        assertArrayEquals(expected, nums1);
    }
}