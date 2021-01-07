package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathVisitingAllNodesTest {
    @Test
    public void testRevisitingSameNodeMultipleTimes() {
        assertEquals(
                4,
                new ShortestPathVisitingAllNodes().shortestPathLength(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{0},
                                new int[]{0},
                                new int[]{0}
                        }
                )
        );
    }

    @Test
    public void testRevisitingSameNodeMultipleTimesWithCycle() {
        assertEquals(
                3,
                new ShortestPathVisitingAllNodes().shortestPathLength(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{0, 2},
                                new int[]{0},
                                new int[]{0}
                        }
                )
        );
    }

    @Test
    public void testCompleteCycle() {
        assertEquals(
                3,
                new ShortestPathVisitingAllNodes().shortestPathLength(
                        new int[][]{
                                new int[]{1},
                                new int[]{2},
                                new int[]{3},
                                new int[]{0}
                        }
                )
        );
    }
}