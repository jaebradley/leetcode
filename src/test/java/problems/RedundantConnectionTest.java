package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedundantConnectionTest {

    @Test
    public void testTriangle() {
        assertArrayEquals(
                new int[] { 1, 3 },
                new RedundantConnection().findRedundantConnection(
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 3 },
                                new int[]{ 1, 3 }
                        }
                )
        );
    }

    @Test
    public void testDifferentOrderTriangle() {
        assertArrayEquals(
                new int[] { 2, 3 },
                new RedundantConnection().findRedundantConnection(
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 },
                        }
                )
        );
    }

    @Test
    public void testSquare() {
        assertArrayEquals(
                new int[]{ 1, 4 },
                new RedundantConnection().findRedundantConnection(
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 3 },
                                new int[]{ 3, 4 },
                                new int[]{ 1, 4 }
                        }
                )
        );
    }
}