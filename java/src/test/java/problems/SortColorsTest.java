package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {
    @Test
    public void twoPassesShouldSort() {
        int[] nums = new int[] {2, 1, 0, 1, 2, 0};
        int[] expected = new int[] {0, 0, 1, 1, 2, 2};
        SortColors.sortColorsTwoPasses(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void twoPassesKeepsOrderWhenAlreadyOrdered() {
        int[] nums = new int[] {0, 1, 2};
        int[] expected = new int[] {0, 1, 2};
        SortColors.sortColorsTwoPasses(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void onePassShouldSort() {
        int[] nums = new int[] {2, 1, 0, 1, 2, 0};
        int[] expected = new int[] {0, 0, 1, 1, 2, 2};
        SortColors.sortColorsOnePass(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void onePassKeepsOrderWhenAlreadyOrdered() {
        int[] nums = new int[] {0, 1, 2};
        int[] expected = new int[] {0, 1, 2};
        SortColors.sortColorsOnePass(nums);
        assertArrayEquals(expected, nums);
    }
}