package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalSquareTest {
    char[][] maximalSquareOfFour = new char[][] {
            new char[] {'1', '0', '1', '0', '0'},
            new char[] {'1', '0', '1', '1', '1'},
            new char[] {'1', '1', '1', '1', '1'},
            new char[] {'1', '0', '0', '1', '0'},
    };

    @Test
    public void maximalSquareShouldBeFour() {
        assertEquals(4, MaximalSquare.maximalSquare(maximalSquareOfFour));
    }

    @Test
    public void emptyMatrixShouldBeZero() { assertEquals(0, MaximalSquare.maximalSquare(new char[][]{})); }
}