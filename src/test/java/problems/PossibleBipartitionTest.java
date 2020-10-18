package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PossibleBipartitionTest {

    @Test
    public void testEmptyIsTrue() {
        assertTrue(new PossibleBipartition().possibleBipartition(0, new int[][]{} ));
    }

    @Test
    public void testTwoConnectedIsTrue() {
        assertTrue(
                new PossibleBipartition().possibleBipartition(
                        2,
                        new int[][]{
                                new int[]{ 1, 2 }
                        }
                )
        );
    }

    @Test
    public void testThreeConnectedIsFalse() {
        assertFalse(
                new PossibleBipartition().possibleBipartition(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 },
                        }
                )
        );
    }

    @Test
    public void testThreePeopleBothConnectedToFirstIsTrue() {
        assertTrue(
                new PossibleBipartition().possibleBipartition(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 1, 3 }
                        }
                )
        );
    }

    @Test
    public void testThreeNobodyIsConnected() {
        assertTrue(
                new PossibleBipartition().possibleBipartition(
                        3,
                        new int[][]{}
                )
        );
    }

    @Test
    public void testThreeOnlyOneConnectedGroup() {
        assertTrue(
                new PossibleBipartition().possibleBipartition(
                        3,
                        new int[][]{
                                new int[]{ 2, 3 }
                        }
                )
        );
    }
 }