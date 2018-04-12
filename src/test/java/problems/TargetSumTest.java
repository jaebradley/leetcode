package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {

    @Test
    public void fiveTargetSums() {
        assertEquals(5, TargetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    @Test
    public void zeroWhenTargetGreaterThanSum() {
        assertEquals(0, TargetSum.findTargetSumWays(new int[]{1, 2}, 100));
    }

    @Test
    public void zeroWhenSingleElementMatchesTarget() {
        assertEquals(1, TargetSum.findTargetSumWays(new int[]{10}, 10));
    }

    @Test
    public void zeroWhenSingleElementDoesNotMatchTarget() {
        assertEquals(0, TargetSum.findTargetSumWays(new int[]{10}, 0));
    }
}