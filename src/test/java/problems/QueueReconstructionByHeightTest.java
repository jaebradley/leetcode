package problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QueueReconstructionByHeightTest {
    @Test
    public void reconstructQueue() {
        int[][] values = new int[][] {
                new int[] {5, 2},
                new int[] {6, 1},
                new int[] {5, 0},
                new int[] {7, 0},
                new int[] {4, 4},
                new int[] {7, 1},
        };
        int[][] expected = new int[][] {
                new int[] {5, 0},
                new int[] {7, 0},
                new int[] {5, 2},
                new int[] {6, 1},
                new int[] {4, 4},
                new int[] {7, 1},
        };

        assertEquals(expected, QueueReconstructionByHeight.reconstructQueue(values));
    }
}