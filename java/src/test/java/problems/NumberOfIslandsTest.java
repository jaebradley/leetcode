package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {
    @Test
    public void zeroIslandsForGridWithOnlyZeros() {
        char[][] grid = new char[][] {
                new char[] {'0', '0', '0'},
                new char[] {'0', '0', '0'},
                new char[] {'0', '0', '0'},
        };
        assertEquals(0, NumberOfIslands.numIslands(grid));
    }

    @Test
    public void zeroIslandForGridWithOne1() {
        char[][] grid = new char[][] {
                new char[] {'0', '0', '0'},
                new char[] {'0', '1', '0'},
                new char[] {'0', '0', '0'},
        };
        assertEquals(1, NumberOfIslands.numIslands(grid));
    }

    @Test
    public void threeIslandForGridWithThreeUnconnectedPiecesOfLand() {
        char[][] grid = new char[][] {
                new char[] {'1', '0', '0'},
                new char[] {'0', '1', '0'},
                new char[] {'0', '0', '1'},
        };
        assertEquals(3, NumberOfIslands.numIslands(grid));
    }

    @Test
    public void oneIslandForGridWithOneConnectedPieceOfLand() {
        char[][] grid = new char[][] {
                new char[] {'1', '1', '1', '1', '0'},
                new char[] {'1', '1', '0', '1', '0'},
                new char[] {'1', '1', '0', '0', '0'},
                new char[] {'0', '0', '0', '0', '0'},
        };
        assertEquals(1, NumberOfIslands.numIslands(grid));
    }
}