package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountServersThatCommunicateTest {
    @Test
    public void testEmptyGrid() {
        assertEquals(
                0,
                new CountServersThatCommunicate().countServers(
                        new int[][]{
                                new int[]{ 0, 0 },
                                new int[]{ 0, 0 }
                        }
                )
        );
    }

    @Test
    public void testSingleValueGrid() {
        assertEquals(
                0,
                new CountServersThatCommunicate().countServers(
                        new int[][]{
                                new int[]{ 1, 0 },
                                new int[]{ 0, 0 }
                        }
                )
        );
    }

    @Test
    public void testGridsWhereServersAreOnOppositeCorners() {
        assertEquals(
                0,
                new CountServersThatCommunicate().countServers(
                        new int[][]{
                                new int[]{ 1, 0 },
                                new int[]{ 0, 1 }
                        }
                )
        );
    }

    @Test
    public void testGridWhereThreeServersShare() {
        assertEquals(
                3,
                new CountServersThatCommunicate().countServers(
                        new int[][]{
                                new int[]{ 1, 0 },
                                new int[]{ 1, 1 }
                        }
                )
        );
    }

    @Test
    public void testGridWhereRowIsAllServers() {
        assertEquals(
                8,
                new CountServersThatCommunicate().countServers(
                        new int[][]{
                                new int[]{ 0,0,0,0},
                                new int[]{ 1,1,1,1 },
                                new int[]{ 0,0,0,1 },
                                new int[]{ 0,0,1,1 },
                                new int[]{ 0,0,0,1 }
                        }
                )
        );
    }
}