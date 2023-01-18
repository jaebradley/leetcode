package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfLongestIncreasingSubsequenceTest {
    @Test
    public void testTwoLongestSubsequences() {
        assertEquals(2, new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{ 1, 3, 5, 4, 7}));
    }

    @Test
    public void testLongestSubsequenceWhenMonotonicallyIncreasing() {
        assertEquals(1, new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{ 1, 2, 3, 4}));
    }

    @Test
    public void testLongestSubsequenceWhenSameValues() {
        assertEquals(5, new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{ 1, 1, 1, 1, 1 }));
    }

    @Test
    public void testLongestSubsequenceWhenMonotonicallyDecreasing() {
        assertEquals(4, new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{ 4, 3, 2, 1 }));
    }
}