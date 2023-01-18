package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {
    @Test
    public void testTwoLevelsWith1() {
        assertEquals(
                1,
                new ContainerWithMostWater().maxArea(new int[]{1, 1})
        );
    }

    @Test
    public void testSecondAndLastLevelsNeeded() {
        assertEquals(
                49,
                new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})
        );
    }

    @Test
    public void testTwoElementMax() {
        assertEquals(
                10,
                new ContainerWithMostWater().maxArea(
                        new int[]{1, 1, 1, 1, 10, 10, 1, 1, 1}
                )
        );
    }

    @Test
    public void testNonGlobalMaximumsProduceMaximumValue() {
        assertEquals(
                25,
                new ContainerWithMostWater().maxArea(
                        new int[]{5, 1, 1, 10, 10, 5}
                )
        );
    }
}