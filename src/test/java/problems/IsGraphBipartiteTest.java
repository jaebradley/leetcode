package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsGraphBipartiteTest {
    @Test
    public void testTwoNodeGraphIsBipartite() {
        assertTrue(new IsGraphBipartite().isBipartite(new int[][]{ new int[]{ 1 }, new int[]{ 0 } }));
    }

    @Test
    public void testThreeNodesGraphIsNotBipartite() {
        assertFalse(new IsGraphBipartite().isBipartite(
                new int[][]{
                        new int[]{ 1, 2 },
                        new int[]{ 0, 2 },
                        new int[]{ 0, 1 }
                }
        ));
    }

    @Test
    public void testSquareIsBipartite() {
        assertTrue(
                new IsGraphBipartite().isBipartite(
                        new int[][]{
                                new int[]{ 1, 3 },
                                new int[]{ 0, 2 },
                                new int[]{ 1, 3 },
                                new int[]{ 0, 2 }
                        }
                )
        );
    }
}