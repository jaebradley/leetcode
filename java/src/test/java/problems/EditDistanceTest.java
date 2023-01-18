package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {
    @Test
    public void testReplaceAndRemovals() {
        assertEquals(3, new EditDistance().minDistance("horse", "ros"));
    }

    @Test
    public void testRemoveReplaceAndInsertions() {
        assertEquals(5, new EditDistance().minDistance("intention", "execution"));
    }

    @Test
    public void testSingleBlankString() {
        assertEquals(9, new EditDistance().minDistance("", "jaebaebae"));
    }

    @Test
    public void testSingleInsertionOrDeletion() {
        assertEquals(1, new EditDistance().minDistance("jaebaebae", "jaeaebae"));
    }

    @Test
    public void testSingleReplacement() {
        assertEquals(1, new EditDistance().minDistance("jaebaebae", "jaejaebae"));
    }
}