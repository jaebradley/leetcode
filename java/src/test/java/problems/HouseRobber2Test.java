package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobber2Test {
    @Test
    public void testThreeHouses() {
        assertEquals(
                3,
                new HouseRobber2().rob(
                        new int[]{2, 3, 2}
                )
        );
    }

    @Test
    public void testTwoHouses() {
        assertEquals(
                2,
                new HouseRobber2().rob(
                        new int[]{1, 2}
                )
        );
    }

    @Test
    public void testRobbingFirstHouseAndSkippingNextTwoHouses() {
        assertEquals(
                20,
                new HouseRobber2().rob(
                        new int[]{10, 1, 2, 10, 3}
                )
        );
    }

    @Test
    public void testSingleValue() {
        assertEquals(
                1,
                new HouseRobber2().rob(
                        new int[]{1}
                )
        );
    }
}