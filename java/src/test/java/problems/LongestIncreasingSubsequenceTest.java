package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void testSameNumberIsOne() {
        assertEquals(1, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{ 1, 1, 1, 1, 1 }));
    }

    @Test
    public void testMonotonicallyIncreasingIsOne() {
        assertEquals(5, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{ 1, 2, 3, 4, 5 }));
    }

    @Test
    public void testMonotonicallyDecreasingIsOne() {
        assertEquals(1, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{ 5, 4, 3, 2, 1 }));
    }

    @Test
    public void testNonconsecutiveSubsequence() {
        assertEquals(5, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{ 1, 2, 3, 5, 4, 7}));
    }

    @Test
    public void testSubsequenceWithThreeLocalMaximums() {
        assertEquals(4, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{ 0, 1, 0, 3, 2, 3 }));
    }
}