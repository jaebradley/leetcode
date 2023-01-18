package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZeroesTest {
    @Test
    public void moveZeroesWhenStartingWithZeroes() {
        int[] values = new int[]{ 0, 1, 0, 3, 12 };
        new MoveZeroes().moveZeroes(values);
        assertArrayEquals(
                new int[]{ 1, 3, 12, 0, 0 },
                values
        );
    }

    @Test
    public void testZeroNumbers() {
        int[] values = new int[]{};
        new MoveZeroes().moveZeroes(values);
        assertArrayEquals(
                new int[]{},
                values
        );
    }
}
