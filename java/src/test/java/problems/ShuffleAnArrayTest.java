package problems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ShuffleAnArrayTest {

    @Test
    public void itShouldReset() {
        int[] values = new int[] { 1, 2, 3, 4 };
        ShuffleAnArray shuffle = new ShuffleAnArray(values);
        assertArrayEquals(values, shuffle.reset());
    }

    @Test
    public void itShouldShuffle() {
        int[] values = new int[] { 1, 2, 3, 4 };
        ShuffleAnArray shuffle = new ShuffleAnArray(values);
        int[] shuffled = shuffle.shuffle();
        assertEquals(shuffled.length, values.length);

        // Pretty shitty check, but oh well
        for (int shuffledValue : shuffled) {
            for (int index = 0; index < values.length; index++) {
                int value = values[index];
                if (value == shuffledValue) {
                    break;
                } else if (index == values.length - 1) {
                    throw new RuntimeException("All values in shuffled should be in original");
                }
            }
        }
    }
}