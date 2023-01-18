package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsecutiveSequenceTest {
    @Test
    public void testSingleValue() {
        assertEquals(
                1,
                new LongestConsecutiveSequence().longestConsecutive(new int[]{1})
        );
    }

    @Test
    public void testSingleValueMultipleTimes() {
        assertEquals(
                1,
                new LongestConsecutiveSequence().longestConsecutive(new int[]{1, 1, 1, 1, 1})
        );
    }

    @Test
    public void testOutOfOrder() {
        assertEquals(
                3,
                new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 1, 57, 3, 29, 2})
        );
    }

    @Test
    public void testReverseOrder() {
        assertEquals(
                3,
                new LongestConsecutiveSequence().longestConsecutive(new int[]{3, 2, 1})
        );
    }

    @Test
    public void testInOrder() {
        assertEquals(
                3,
                new LongestConsecutiveSequence().longestConsecutive(new int[]{1, 2, 3})
        );
    }
}