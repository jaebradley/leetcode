package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidSudokuTest {
    @Test
    public void testDuplicateInRowReturnsFalse() {
        assertFalse(
                new ValidSudoku().isValidSudoku(
                        new char[][]{
                                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                new char[]{'.', '.', '.', '9', '1', '9', '.', '.', '5'},
                                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                        }
                )
        );
    }

    @Test
    public void testDuplicateInColumnReturnsFalse() {
        assertFalse(
                new ValidSudoku().isValidSudoku(
                        new char[][]{
                                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                new char[]{'.', '.', '.', '8', '1', '9', '.', '.', '5'},
                                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                        }
                )
        );
    }

    @Test
    public void testInvalidSubboxReturnsFalse() {
        assertFalse(
                new ValidSudoku().isValidSudoku(
                        new char[][]{
                                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                        }
                )
        );
    }

    @Test
    public void testInvalidLastSquareReturnsFalse() {
        assertFalse(
                new ValidSudoku().isValidSudoku(
                        new char[][]{
                                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                new char[]{'.', '.', '.', '4', '1', '9', '8', '.', '5'},
                                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                        }
                )
        );
    }

    @Test
    public void testValidSudokuReturnsTrue() {
        assertTrue(
                new ValidSudoku().isValidSudoku(
                        new char[][]{
                                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                        }
                )
        );
    }
}