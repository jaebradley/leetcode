package problems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MinimumNumberOfVerticesToReachAllNodesTest {

    @Test
    public void testFindingMinimumVerticesForSingleEdge() {
        assertEquals(
                List.of(0),
                new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(
                        2,
                        List.of(
                                List.of(0, 1)
                        )
                )
        );
    }

    @Test
    public void testFindingMMinimumVerticesForTwoEdges() {
        assertEquals(
                List.of(0),
                new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(
                        3,
                        List.of(
                                List.of(0, 1),
                                List.of(0, 2)
                        )
                )
        );
    }

    @Test
    public void testTwoOriginsThatPointToSharedVertex() {
        assertEquals(
                List.of(0, 1),
                new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(
                        3,
                        List.of(
                                List.of(0, 2),
                                List.of(1, 2)
                        )
                )
        );
    }

    @Test
    public void testSingleOriginThatPointsToSingleVertexThatPointsToSingleVertex() {
        assertEquals(
                List.of(0),
                new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(
                        3,
                        List.of(
                                List.of(0, 1),
                                List.of(1, 2)
                        )
                )
        );
    }
}