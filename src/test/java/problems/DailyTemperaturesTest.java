package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperaturesTest {
    @Test
    public void testMonotonicallyDecreasingTemperatures() {
        assertArrayEquals(
                new int[]{0, 0, 0, 0, 0 },
                new DailyTemperatures().dailyTemperatures(new int[]{ 5, 4, 3, 2, 1 })
        );
    }

    @Test
    public void testMonotonicallyIncreasingTemperatures() {
        assertArrayEquals(
                new int[]{ 1, 1, 1, 1, 0 },
                new DailyTemperatures().dailyTemperatures(new int[]{ 1, 2, 3, 4, 5 })
        );
    }

    @Test
    public void testDecreasingThenIncreasingTemperatures() {
        assertArrayEquals(
                new int[]{ 0, 3, 1, 1, 0 },
                new DailyTemperatures().dailyTemperatures(new int[]{ 3, 2, 1, 2, 3 })
        );
    }

    @Test
    public void testIncreasingThenDecreasingTemperatures() {
        assertArrayEquals(
                new int[]{ 1, 1, 0, 0, 0 },
                new DailyTemperatures().dailyTemperatures(new int[]{ 1, 2, 3, 2, 1 })
        );
    }

    @Test
    public void testAllSameValues() {
        assertArrayEquals(
                new int[]{ 0, 0, 0, 0, 0 },
                new DailyTemperatures().dailyTemperatures(new int[]{ 1, 1, 1, 1, 1 })
        );
    }
}
