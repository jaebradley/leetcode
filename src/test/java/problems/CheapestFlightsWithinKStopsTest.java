package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheapestFlightsWithinKStopsTest {
    @Test
    public void testNoStops() {
        assertEquals(
                500,
                new CheapestFlightsWithinKStops().findCheapestPrice(
                        3,
                        new int[][]{
                                new int[]{0, 1, 100},
                                new int[]{1, 2, 100},
                                new int[]{0, 2, 500}
                        },
                        0,
                        2,
                        0

                )
        );
    }

    @Test
    public void testOneStop() {
        assertEquals(
                200,
                new CheapestFlightsWithinKStops().findCheapestPrice(
                        3,
                        new int[][]{
                                new int[]{0, 1, 100},
                                new int[]{1, 2, 100},
                                new int[]{0, 2, 500}
                        },
                        0,
                        2,
                        1

                )
        );
    }

    @Test
    public void testNotPossible() {
        assertEquals(
                -1,
                new CheapestFlightsWithinKStops().findCheapestPrice(
                        3,
                        new int[][]{
                                new int[]{0, 1, 100},
                                new int[]{1, 2, 100},
                                new int[]{2, 3, 100}
                        },
                        0,
                        3,
                        1

                )
        );
    }
}