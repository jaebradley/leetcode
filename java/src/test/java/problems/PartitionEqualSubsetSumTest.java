package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionEqualSubsetSumTest {

    @Test
    public void cannotPartitionForSingleNonZeroElement() {
        assertFalse(PartitionEqualSubsetSum.canPartition(new int[]{1}));
    }

    @Test
    public void canPartitionForFiveElements() {
        assertTrue(PartitionEqualSubsetSum.canPartition(new int[]{2, 3, 4, 5, 6}));
    }
}